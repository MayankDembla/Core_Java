package com.dembla.jvm.mutithreading.interruption;

import java.io.*;

public class IOUtil {

    public static String read(InputStream io){
        StringBuilder text = new StringBuilder() ;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(io,"UTF-8"))){
            String line ;
            while((line = br.readLine()) != null){
                text.append(line).append("\n") ;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text.toString() ;
    }

}
