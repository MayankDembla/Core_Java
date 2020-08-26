package streamapi.lectures;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lecture10 {


    private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
            Lists.newArrayList("Mariam", "Alex", "Ismail"),
            Lists.newArrayList("John", "Alesha", "Andre"),
            Lists.newArrayList("Susy", "Ali")
    );

    @Before
    public void setUp() {
        System.out.println(arrayListOfNames);
    }

    @Test
    public void withoutFlatMap() throws Exception {
//  [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]

        ArrayList<String> list = Lists.newArrayList();

        for (ArrayList<String> l : arrayListOfNames){
            for(String name : l ){
                list.add(name) ;
            }
        }

        System.out.println(list);
    }

    @Test
    public void withFlatMap() {

        List<String> collect = arrayListOfNames.stream().flatMap(List::stream).collect(Collectors.toList());

        System.out.println(collect);
    }
}
