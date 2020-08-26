package streamapi.lectures;

import org.junit.Test;
import streamapi.beans.Car;
import streamapi.mockdata.MockData;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Grouping data with Streams
 */
public class Lecture8 {

    @Test
    public void simpleGrouping() throws IOException {

        Map<String, List<Car>> collect = MockData.getCars().stream().collect(Collectors.groupingBy(Car::getMake));

        collect.forEach((make, cars) -> {
            System.out.println("######### "+ make + " #########");
            cars.forEach(System.out::println);
            System.out.println();
        });
    }


}
