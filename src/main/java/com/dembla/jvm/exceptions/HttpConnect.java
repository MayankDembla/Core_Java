package com.dembla.jvm.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpConnect {

   public static String send(int destination , String data , String partner ) throws IOException {
       System.out.println("/nInside send ....");
       String response = "success" ;

       if(destination < 0 || destination > 1){
           throw  new IllegalArgumentException() ;
       }

       if (destination == 1) {
           throw new FileNotFoundException() ;
       }else if(destination == 0 ){
//           throw  new IOException() ;
            response= "<result><code>success</code></result>" ;
       }
       System.out.println("/nEnd of Send Method ... ");

       return response ;
   }

}
