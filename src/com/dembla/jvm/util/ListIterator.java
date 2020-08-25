package com.dembla.jvm.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator {

    public static void main(String[] args) {

        List<Element> listElement = new ArrayList<>() ;
        listElement.add(new Element("nonParagraph1", "a")) ;
        listElement.add(new Element("para 1 ", "p")) ;
        listElement.add(new Element("para 2", "p")) ;
        listElement.add(new Element("para 3", "p")) ;
        listElement.add(new Element("Non Para 2", "e")) ;
        listElement.add(new Element("Non Para 3", "f")) ;


        Iterator<Element> elementIterator = listElement.iterator() ;

        StringBuilder builder = new StringBuilder() ;

        while (elementIterator.hasNext()){

            Element e = elementIterator.next() ;
            if(e.getTag().equals("p")){

                 builder.append(e.getText()) ;
                while ( elementIterator.hasNext()){
                    Element e1 = elementIterator.next() ;

                    if(e1.getTag().equals("p")) {
                        builder.append(e1.getText()) ;
                        elementIterator.remove();
                    }else {
                        break;
                    }
                }
                e.setText(builder.toString());
            }
        }

        System.out.println(listElement);

    }

}



class Element {

   private String text ;
    private  String tag ;

    Element(String text , String body){
        this.text = text ;
        this.tag = body ;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String body) {
        this.tag = body;
    }

    @Override
    public String toString() {
        return "Element{" +
                "text='" + text + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}