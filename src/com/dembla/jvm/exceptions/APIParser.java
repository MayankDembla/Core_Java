package com.dembla.jvm.exceptions;

public class APIParser {

    public static  void parsesendResponseCode(String response , String data , String url ) throws APIFormatChangeException {
       int responsecode = -1;
       try {
           String startTag = "<code>";
           String endTag = "</code>";
           if (response.contains(startTag)) {
               int beginIndex = response.indexOf(startTag) + startTag.length();
               int endIndex = response.indexOf(endTag);
               System.out.println("code : " + response.substring(beginIndex, endIndex));
               responsecode = Integer.parseInt(response.substring(beginIndex, endIndex));
           }
       }catch (NumberFormatException ex){
          throw new APIFormatChangeException("Detailed Message") ;
       }

    }
}
