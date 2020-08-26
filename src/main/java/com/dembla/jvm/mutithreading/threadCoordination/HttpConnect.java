package com.dembla.jvm.mutithreading.threadCoordination;

import java.io.IOException;
import java.net.*;

public class HttpConnect {

    public static String download(String sourceUrl) throws URISyntaxException, IOException {
        System.out.println("Downloading : " + sourceUrl);
        URL url = new URI(sourceUrl).toURL();

        HttpURLConnection con = (HttpURLConnection) url.openConnection() ;
        int responseCode= con.getResponseCode() ;

        if(responseCode > 200 && responseCode < 300) {
            return IOUtil.read(con.getInputStream());
        }

       return null ;
    }
}
