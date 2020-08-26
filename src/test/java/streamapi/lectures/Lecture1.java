package streamapi.lectures;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import streamapi.beans.Person;
import streamapi.mockdata.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lecture1 {

    @Test
    public void imperativeApporach() throws IOException {

        List<Person> people = MockData.getPeople();

        // 1. Find people aged less or equal 18
        List<Person> peoplelessthanEighteen = new ArrayList<>();

        for (Person p : people) {
            if (p.getAge() <= 18) {
                peoplelessthanEighteen.add(p);
            }
        }

        System.out.println(peoplelessthanEighteen);

        // 2. Then change implementation to find first 10 people
        List<Person> peoplelessthaneighteenandfirstten = new ArrayList<>();

        if (peoplelessthanEighteen.size() <= 10)
            peoplelessthaneighteenandfirstten = peoplelessthanEighteen;
        else {
            int count = 0;
            for (Person p : peoplelessthanEighteen) {
                peoplelessthaneighteenandfirstten.add(p) ;
                count++ ;
                if(count >= 10 )
                    break ;
            }
        }

        System.out.println(peoplelessthaneighteenandfirstten);
    }

    @Test
    public void declarativeapproachUsingStream() throws IOException {

        ImmutableList<Person> people = MockData.getPeople() ;

        List<Person> youngPeople = people.stream().filter(person -> person.getAge() >= 18).collect(Collectors.toList());

        youngPeople.forEach(System.out::println);

        List<Person> young10people = people.stream().filter(person ->  person.getAge() <= 18).limit(10).collect(Collectors.toList());

        young10people.forEach(System.out::println);

    }
}
