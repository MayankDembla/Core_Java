package com.dembla.jvm.mutithreading.executorframework;

import com.dembla.jvm.mutithreading.threadCoordination.HttpConnect;
import com.dembla.jvm.mutithreading.threadCoordination.NaiveIndexer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NaiveExecutorIndexer {

    private Deque<WebLink> queue = new ArrayDeque<>() ;

    // Executors
    Executor downloadExecutor = Executors.newFixedThreadPool(2) ;
    Executor indexExecutor = Executors.newFixedThreadPool(2) ;

    private static class WebLink {
        private long id;
        private String title;
        private String url;
        private String host;

        // Getter Setter
        private volatile String htmlPage;

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
                String htmlPage = HttpConnect.download(webLink.getUrl());
                webLink.setHtmlPage(htmlPage);
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
            while (true) {
                String htmlPage = webLink.getHtmlPage();
                if (htmlPage != null) {
                    index(htmlPage);
                    break;
                } else {
                    System.out.println(webLink.getId() + " not yet downloaded! ");
                }
            }
        }

        private void index(String text){
            if(text != null ){
                System.out.println("\nIndexed: " + webLink.getId() + "\n");
            }
        }
    }


    public void go() {
        while (queue.size() > 0) {
            WebLink webLink = queue.remove();

            downloadExecutor.execute(new Downloader(webLink));
            indexExecutor.execute(new Indexer(webLink));
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
        NaiveExecutorIndexer naiveIndexer = new NaiveExecutorIndexer();
        naiveIndexer.add(naiveIndexer.createWebLink(2000, "Taming Tiger, Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com"));

        naiveIndexer.add(naiveIndexer.createWebLink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?",
                "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
                "http://www.stackoverflow.com"));

        naiveIndexer.add(naiveIndexer.createWebLink(2002, "Interface vs Abstract Class",
                "http://mindprod.com/jgloss/interfacevsabstract.html",
                "http://mindprod.com"));

        naiveIndexer.add(naiveIndexer.createWebLink(2004, "Virtual Hosting and Tomcat",
                "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html",
                "http://tomcat.apache.org"));

        naiveIndexer.add(naiveIndexer.createWebLink(2003, "Taming Tiger, part 4",
                "Host4.com",
                "Host 4"));

        naiveIndexer.go();
    }
}
