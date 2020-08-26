package com.dembla.jvm.nestedclasses;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import javax.xml.bind.JAXB;
import java.io.StringWriter;
import java.util.Map;

public class DataTranslator {

    public static String getBooksAsXML(int id, String title, double rating, int fbLikes, int tweetCounts) {

        class Book {
            private int id;
            private String title;
            private double rating;
            private int fbLikesCount;
            private int tweetCounts;

            public Book(int id, String title, double rating, int fbLikesCount, int tweetCounts) {
                this.id = id;
                this.title = title;
                this.rating = rating;
                this.fbLikesCount = fbLikesCount;
                this.tweetCounts = tweetCounts;
            }
        }

        // Local Class would be instantiated within the method.
        Book book = new Book(id, title, rating, fbLikes, tweetCounts);

        XStream xStream = new XStream(new StaxDriver());
        xStream.alias("book", Book.class);
        StringWriter writer = new StringWriter();
        xStream.marshal(book, new PrettyPrintWriter(writer));

        return writer.toString();
    }

    public static void main(String[] args) {

        System.out.println(DataTranslator.getBooksAsXML(2002, "Interface vs Abstract Class",
                3.0, 2, 3));
    }
}
