package com.dembla.jvm.lamdasfp.lecture2;

import org.htmlcleaner.HtmlCleaner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        String doc1 = "<html><body>One of the most common uses of <i>streams</i> is to represent queries over data in collections</body></html>";
        String doc2 = "<html><body>Information integration systems provide valuable services to users by integrating information from a number of autonomous, heterogeneous and distributed Web sources</body></html>";
        String doc3 = "<html><body>Solr is the popular, blazing fast open source enterprise search platform from the Apache Lucene</body></html>";
        String doc4 = "<html><body>Java 8 goes one more step ahead and has developed a streams API which lets us think about parallelism</body></html>";

        List<String> documents = new ArrayList<>(Arrays.asList(doc1, doc2, doc3, doc4));

        for (String doc : documents) {

            // ## 1. For Filtering we are using the predicate
            boolean isTargetDoc = filter(doc, d -> d.contains("stream"));

            // ## 2. And for transformation we are using the Function
            if (isTargetDoc) {

                // 1. Passing Lambda expression in the function parameter

                doc = transformation(doc, d -> Indexer.stripHtmlTags(d));
                // Behaviour is passed via the lambda.
                doc = transformation(doc, d -> Indexer.removeStopTags(d));

                // 2. We can also pass it using the Variable

                Function<String, String> function = d -> Indexer.stripHtmlTags(d);
                Function<String, String> function2 = d -> Indexer.removeStopTags(d);

                doc = transformation(doc, function);
                doc = function2.apply(doc) ;

                System.out.println(doc);
            }

        }
    }

    static boolean filter(String doc, Predicate<String> filter) {
        return filter.test(doc);
    }

    static String transformation(String doc, Function<String, String> transformer) {
        return transformer.apply(doc);
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