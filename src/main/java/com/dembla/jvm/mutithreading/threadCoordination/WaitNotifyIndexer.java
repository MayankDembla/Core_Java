package com.dembla.jvm.mutithreading.threadCoordination;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * For N web links, this approach creates 2 * N threads.
 * <p>
 * Note: htmlPage is declared volatile in Weblink
 * <p>
 * Limitation:
 * CPU cycles are wasted in Indexer as it is waiting for page to be downloaded
 */
public class WaitNotifyIndexer {

    private Deque<WebLink> queue = new ArrayDeque<>();

    private static class WebLink {
        private long id;
        private String title;
        private String url;
        private String host;

        public long getId() {
            return id;
        }

        private String htmlPage;

        // Getter Setter

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

        public String getHtmlPage() {
            return htmlPage;
        }

        public void setHtmlPage(String htmlPage) {
            this.htmlPage = htmlPage;
        }
    }

    public static class Downloader implements Runnable {
        private WebLink webLink;

        public Downloader(WebLink webLink) {
            this.webLink = webLink;
        }

        @Override
        public void run() {

            try {
                synchronized (webLink) {
                    String htmlPage = HttpConnect.download(webLink.getUrl());
                    webLink.setHtmlPage(htmlPage);

                    // this will wake the other thread
                    // But not release the lock.
                    webLink.notify();
                }
                // Lock will be released here

            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static class Indexer implements Runnable {
        private WebLink webLink;

        private Indexer(WebLink webLink) {
            this.webLink = webLink;
        }

        @Override
        public void run() {
            String htmlPage = webLink.getHtmlPage();

            synchronized (webLink) {
                try {
                    while (htmlPage == null) {
                        // In Object Class, this will suspend the thread.
                        // State is the Waiting State.
                        System.out.println(webLink.getId() + " not yet downloaded ! ");
                        webLink.wait(); // Release the Lock
                        System.out.println(webLink.getId() + " awakened !");
                        htmlPage = webLink.getHtmlPage();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                index(htmlPage);
            }

        }

        private void index(String text) {
            if (text != null) {
                System.out.println("\nIndexed: " + webLink.getId() + "\n");
            }
        }
    }

    public void go() {
        while (queue.size() > 0) {
            WebLink webLink = queue.remove();
            Thread downloaderThread = new Thread(new Downloader(webLink));
            Thread indexer = new Thread(new Indexer(webLink));

            downloaderThread.start();
            indexer.start();
        }
    }

    public void add(WebLink webLink) {
        queue.add(webLink);
    }

    public WebLink createWebLink(long id, String title, String url, String host) {
        WebLink webLink = new WebLink();
        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setHost(host);
        webLink.setUrl(url);

        return webLink;
    }


    public static void main(String[] args) {

        WaitNotifyIndexer waitNotifyIndexer = new WaitNotifyIndexer();
        waitNotifyIndexer.add(waitNotifyIndexer.createWebLink(2000, "Taming Tiger, Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com"));

        waitNotifyIndexer.add(waitNotifyIndexer.createWebLink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?",
                "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
                "http://www.stackoverflow.com"));

        waitNotifyIndexer.add(waitNotifyIndexer.createWebLink(2002, "Interface vs Abstract Class",
                "http://mindprod.com/jgloss/interfacevsabstract.html",
                "http://mindprod.com"));

        waitNotifyIndexer.add(waitNotifyIndexer.createWebLink(2004, "Virtual Hosting and Tomcat",
                "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html",
                "http://tomcat.apache.org"));

        waitNotifyIndexer.add(waitNotifyIndexer.createWebLink(2003, "Taming Tiger, part 4",
                "Host4.com",
                "Host 4"));

        waitNotifyIndexer.go();
    }

}
