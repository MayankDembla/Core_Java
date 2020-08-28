package streamapi.lectures;

import com.google.common.collect.Lists;
import org.junit.Test;
import streamapi.beans.Car;
import streamapi.mockdata.MockData;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Grouping data with Streams
 */
public class Lecture8 {

    @Test
    public void simpleGrouping() throws IOException {

        Map<String, List<Car>> collect = MockData.getCars().stream().collect(Collectors.groupingBy(Car::getMake));

        collect.forEach((make, cars) -> {
            System.out.println("######### " + make + " #########");
            cars.forEach(System.out::println);
            System.out.println();
        });
    }

    @Test
    public void groupingAndCounting() {

        ArrayList<String> strings = Lists.newArrayList("John", "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex");

        Map<String, Long> counting = strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        counting.forEach((name,count) -> System.out.println(name + " > " + count));

    }

}
