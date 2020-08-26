package streamapi.lectures;

import org.junit.Test;

import java.util.stream.IntStream;

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

        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }

}


