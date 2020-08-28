package streamapi.lectures;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Find Any and Find First.
 */
public class Lecture6 {

    final Predicate<Integer> integerPredicate = n -> n > 5 && n < 10;

    @Test
    public void findAny() throws Exception {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        final Integer any = Arrays.stream(numbers)
                .filter(integerPredicate)
                .findAny()
                .get();

        System.out.println(any);
    }

    @Test
    public void findFirst() throws Exception {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        final Integer first = Arrays.stream(numbers)
                .filter(integerPredicate)
                .findFirst() // Find the First Number which satisfy our condition.
                .get();

        System.out.println(first);
    }

}
