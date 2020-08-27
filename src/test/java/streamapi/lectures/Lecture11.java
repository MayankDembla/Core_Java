package streamapi.lectures;

import com.dembla.jvm.assertion.p1.C;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Lecture11 {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

        String concatinatename = "";

        for (String name : names) {
            concatinatename += name + ", ";
        }
        System.out.println(concatinatename.substring(0,concatinatename.length()-2));

        // Using Stream
        String Collectusingstream = names.stream().collect(Collectors.joining(","));

    }

    @Test
    public void joiningstreamWithStream() {
        List<String> list = ImmutableList.of("anna", "john", "marcos", "helana", "yasmin");

        String join = list.stream().map(String::toUpperCase).collect(Collectors.joining("|")) ;

        System.out.println(join);
    }
}
