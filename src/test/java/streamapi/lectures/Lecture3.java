package streamapi.lectures;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;

/**
 * Min, Max and Comparator
 */
public class Lecture3 {

    @Test
    public void min() {

        final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

        Integer min = numbers.stream().min(Comparator.naturalOrder()).get();

        assertThat(min).isEqualTo(1);
        System.out.println(min);

    }

    @Test
    public void max() {

        final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 140, 23, 93, 99);

        Integer max = numbers.stream().max(Comparator.naturalOrder()).get();

        assertThat(max).isEqualTo(140);
        System.out.println(max);

    }

}
