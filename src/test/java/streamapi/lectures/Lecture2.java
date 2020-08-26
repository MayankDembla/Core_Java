package streamapi.lectures;

import org.junit.Test;
import streamapi.beans.Person;
import streamapi.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

/**
 * IntStream.range
 * IntStream.iterate
 */
public class Lecture2 {

    @Test
    public void range() {
        System.out.println("for i");

        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        System.out.println("Exclusive");

        IntStream.range(0, 10).forEach(System.out::println);

        System.out.println("Inclusive");

        IntStream.rangeClosed(0, 10).forEach(i -> System.out.println(i));

    }


    @Test
    public void rangeIteratingList() throws IOException {
        List<Person> people = MockData.getPeople();

        IntStream.range(0, people.size()).forEach(index -> {
            Person person = people.get(index);
            System.out.println(person);
        });
    }

    @Test
    public void intStreamIterate() {
        IntStream.iterate(0, operand -> operand + 1) // start , function
                .filter(number -> number % 2 != 0)
                .limit(10)
                .forEach(System.out::println);
    }

}


