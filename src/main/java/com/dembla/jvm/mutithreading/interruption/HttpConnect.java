package com.dembla.jvm.mutithreading.interruption;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class HttpConnect {

    public static String download(String sourceurl) throws URISyntaxException, MalformedURLException {
        System.out.println("Downloading... " + sourceurl);
        URL url = new URI(sourceurl).toURL() ;

        try{
            HttpURLConnection con = (HttpURLConnection) url.openConnection() ;

            int responseCode = con.getResponseCode() ;

            if(responseCode >= 200 && responseCode < 300){
               return IOUtil.read(con.getInputStream()) ;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
       return null ;
    }

    public static String download(InputStream io){
        return IOUtil.read(io) ;
    }

    public static InputStream getInputStream(String sourceurl) throws URISyntaxException, MalformedURLException {
        System.out.println("Downloading " + sourceurl);
        URL url = new URI(sourceurl).toURL() ;
        InputStream in = null ;

        try{
            HttpURLConnection con = (HttpURLConnection) url.openConnection() ;
            int resposeCode = con.getResponseCode() ;

            if(resposeCode >= 200 && resposeCode < 300){ // OK
                in = con.getInputStream() ;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return in ;
    }
}
