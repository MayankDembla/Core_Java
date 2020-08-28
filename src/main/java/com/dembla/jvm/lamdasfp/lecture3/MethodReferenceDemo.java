package com.dembla.jvm.lamdasfp.lecture3;

import com.dembla.jvm.mutithreading.executorframework.FutureIndexer;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.htmlcleaner.HtmlCleaner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        String doc1 = "<html><body>One of the most common uses of <i>streams</i> is to represent queries over data in collections</body></html>";
        String doc2 = "<html><body>Information integration systems provide valuable services to users by integrating information from a number of autonomous, heterogeneous and distributed Web sources</body></html>";
        String doc3 = "<html><body>Solr is the popular, blazing fast open source enterprise search platform from the Apache Lucene</body></html>";
        String doc4 = "<html><body>Java 8 goes one more step ahead and has developed a streams API which lets us think about parallelism</body></html>";

        List<String> documets = new ArrayList<>(Arrays.asList(doc1,doc2,doc3,doc4)) ;

        for(String doc: documets){

            //3.  Method Reference (className:: instanceMethod)
            BiFunction<String,String, Boolean> bifun = String::contains ;

            // 2. Method Reference (instance variable :: instanceMethod)
            Function<String,Boolean> fun = doc::contains;


            if(bifun.apply(doc,"stream")){

                // 1. Method reference (className:: staticMethod)
                Function<String,String> htmlCleaner = Indexer::stripHtmlTags;
                Function<String,String> stopWordRemover = Indexer::removeStopTags;

                htmlCleaner.apply(doc);
                htmlCleaner.apply(doc);

            }

        }

    }
}

class Indexer {
    private static List<String> stopWords = Arrays.asList("of", "the", "a", "is", "to", "in", "and");

    static String stripHtmlTags(String doc) {
        return new HtmlCleaner().clean(doc).getText().toString();
    }

    static String removeStopTags(String doc) {

        StringBuilder sb = new StringBuilder();
        for (String word : doc.split(" ")) {
            if (!stopWords.contains(word))
                sb.append(word).append(" ");
        }

        return sb.toString();
    }

}