package com.dembla.jvm.mutithreading.executorframework;

import com.dembla.jvm.mutithreading.interruption.HttpConnect;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.*;

public class FutureIndexer {

    private Deque<WebLink> queue = new ArrayDeque<>() ;

    // Executors
    ExecutorService downloadExecutor = Executors.newFixedThreadPool(2) ;
    ExecutorService indexExecutor = Executors.newFixedThreadPool(2) ;

    public static class WebLink{

        private int id ;
        private String title ;
        private String host ;
        private String url ;
        private String htmlPage ;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHtmlPage() {
            return htmlPage;
        }

        public void setHtmlPage(String htmlPage) {
            this.htmlPage = htmlPage;
        }
    }


    public static class Downloader implements Callable<WebLink> {

        private WebLink webLink;

        Downloader(WebLink webLink) {
            this.webLink = webLink;
        }

        @Override
        public WebLink call() {

            try {
                String htmlpage = HttpConnect.download(webLink.getUrl());
                webLink.setHtmlPage(htmlpage);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return webLink ;
        }
    }

    public static class Indexer implements Runnable {

        private WebLink webLink;

        Indexer(WebLink webLink) {
            this.webLink = webLink;
        }

        @Override
        public void run() {
            String htmlPage = webLink.getHtmlPage();
            index(htmlPage);
        }

        private void index(String text) {
            if (text == null) {
                System.out.println("\n Indexed : " + webLink.getId() + "\n");
            }
        }
    }

    public void go(){

        List<Future<WebLink>> futures = new ArrayList<>() ;

        while(queue.size() > 0 ){
            WebLink webLink = new WebLink() ;

            futures.add(downloadExecutor.submit(new Downloader(webLink))) ;
        }

        for(Future<WebLink> future : futures){
            try {
                indexExecutor.execute(new Indexer(future.get()));
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

         downloadExecutor.shutdown();
         indexExecutor.shutdown();

        //downloadExecutor.submit(new Downloader<Weblink>(new FutureIndexer().createWeblink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com")));

    }

    public void add(WebLink link){
        queue.add(link) ;
    }

    public WebLink createWebLink(int id, String title, String url, String host ){

        WebLink webLink = new WebLink() ;
        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setUrl(url);
        webLink.setHost(host);

        return webLink;
    }

    public static void main(String[] args) {
        FutureIndexer futureIndexer = new FutureIndexer();
        futureIndexer.add(futureIndexer.createWebLink(2000, "Taming Tiger, Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com"));

        futureIndexer.add(futureIndexer.createWebLink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?",
                "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
                "http://www.stackoverflow.com"));

        futureIndexer.add(futureIndexer.createWebLink(2002, "Interface vs Abstract Class",
                "http://mindprod.com/jgloss/interfacevsabstract.html",
                "http://mindprod.com"));

        futureIndexer.add(futureIndexer.createWebLink(2004, "Virtual Hosting and Tomcat",
                "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html",
                "http://tomcat.apache.org"));

        futureIndexer.add(futureIndexer.createWebLink(2003, "Taming Tiger, part 4",
                "Host4.com",
                "Host 4"));

        futureIndexer.go();
    }

}
