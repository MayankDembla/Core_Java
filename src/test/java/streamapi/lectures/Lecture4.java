package streamapi.lectures;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Distinct and Collector.toSet
 */
public class Lecture4 {

    @Test
    public void distinct() throws Exception {
        final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        List<Integer> distictNumbers = numbers.stream().distinct().collect(Collectors.toList());

        assertThat(distictNumbers).hasSize(9);

        System.out.println(distictNumbers);
    }

    @Test
    public void distinctWithSet() {
        final List<Integer> numbers = ImmutableList.of(56,1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        Set<Integer> distictNumber = numbers.stream().collect(Collectors.toSet());

        String number = distictNumber.toString() .substring(1);

        assertThat(distictNumber).hasSize(10);
    }
}
