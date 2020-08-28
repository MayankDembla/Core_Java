package com.dembla.jvm.mutithreading.interruption;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.SQLOutput;
import java.sql.Time;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitAndNotifyWithIncompleteInterruption {

    private Deque<WebLink> queue = new ArrayDeque<>();

    private List<Thread> downloadThreadList = new ArrayList<>();
    private List<Thread> indexThreadList = new ArrayList<>();

    public static class WebLink {

        private long id;
        private String title;
        private String url;
        private String host;
        private volatile boolean stop;
        private String htmlPage;

        // Getter Setter
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public boolean isStop() {
            return stop;
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }

        public String getHtmlPage() {
            return htmlPage;
        }

        public void setHtmlPage(String htmlPage) {
            this.htmlPage = htmlPage;
        }
    }

    public static class Downloader implements Runnable {

        private WebLink webLink;

        Downloader(WebLink webLink) {
            this.webLink = webLink;
        }

       // Downloader - Run Method
        @Override
        public void run() {

            synchronized (webLink) {
                try {
                    InputStream in = HttpConnect.getInputStream(webLink.getUrl());

                    // background Process for Stopping download Process
                    Thread bgThread = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                while (!webLink.isStop()) {
                                    TimeUnit.SECONDS.sleep(1);
                                }
                                System.out.println("Time out. Closing stream for " + webLink.getId());
                                in.close();
                            } catch (InterruptedException  exception) {
                                System.out.println("bgThread interrupted -- " + webLink.getId());
                            } catch ( IOException ex){
                                System.out.println("bgThread IO Exception  -- " + webLink.getId());
                            }
                        }
                    });

                    bgThread.start();

                    String htmlPage;
                    try {
                        htmlPage = HttpConnect.download(in);
                        System.out.println(webLink.getId() + "Download Complete ...");
                        webLink.setHtmlPage(htmlPage);

                        bgThread.interrupt();

                        webLink.notifyAll();
                    } catch (Exception exception) {
                        System.out.println(webLink.getId() + " Can't be downloaded Terminating as Stream Closed !!!");
                    }
                    // Lock is released..
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Indexer implements Runnable {

        private WebLink weblink;

        Indexer(WebLink webLink) {
            this.weblink = webLink;
        }

      // Interrupter - Run Method.
        @Override
        public void run() {

            try {
                // Threads waiting here on intrinsic locks are uninterruptible
                synchronized (weblink) {
                    String htmlPage = weblink.getHtmlPage();
                    while (htmlPage == null) {
                        try {
                            System.out.println(weblink.getId() + " not yet downloaded. Waiting ...");
                            weblink.wait();
                            System.out.println(weblink.getId() + " awakened!");
                            htmlPage = weblink.getHtmlPage();
                        } catch (InterruptedException e) {
                            throw e;
                        } // WAITING
                    }
                    index(htmlPage);
                }
            } catch (InterruptedException e) {
                System.out.println(weblink.getId() + " (indexer) interrupted!!");

                // Clean-up: Stopping downloader thread indirectly
                weblink.setStop(true);
            }

        }

        private void index(String text) {
            if (text != null) {
                System.out.println("\nIndexed: " + weblink.getId() + "\n");
            }
        }
    }

    public void go() {
        while (queue.size() > 0) {
            WebLink webLink = queue.remove();
            Thread downloadThread = new Thread(new Downloader(webLink));
            Thread indexerThread = new Thread(new Indexer(webLink));

            downloadThreadList.add(downloadThread);
            indexThreadList.add(indexerThread);

            downloadThread.start();
            indexerThread.start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        // Interruption downloader threads that gets blocked.
        System.out.println("\n Times Up !!\n");

        for (int i = 0; i < downloadThreadList.size(); i++) {
            Thread downloaderThread = downloadThreadList.get(i);

            if (downloaderThread.isAlive()) {
                System.out.println(downloaderThread.getName() + " is Still Alive. Stopping it ...");
                indexThreadList.get(i).interrupt();
            }
        }
    }

    public void add(WebLink webLink) {
        queue.add(webLink);
    }

    public WebLink createWebLink(long id, String title, String url, String host) {

        WebLink webLink = new WebLink();
        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setUrl(url);
        webLink.setHost(host);
        return webLink;
    }

    public static void main(String[] args) {

        WaitAndNotifyWithIncompleteInterruption incompleteInterruption = new WaitAndNotifyWithIncompleteInterruption();
        incompleteInterruption.add(incompleteInterruption.createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com"));
        incompleteInterruption.add(incompleteInterruption.createWebLink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com"));
        incompleteInterruption.add(incompleteInterruption.createWebLink(2002, "Interface vs Abstract Class", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
        incompleteInterruption.add(incompleteInterruption.createWebLink(2003, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
        incompleteInterruption.go();
    }

}
