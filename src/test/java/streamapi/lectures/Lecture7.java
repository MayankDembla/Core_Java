package streamapi.lectures;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import streamapi.beans.Car;
import streamapi.beans.Person;
import streamapi.mockdata.MockData;

import java.io.IOException;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Lecture7 {

    @Test
    public void count() throws IOException {

        final long females = MockData.getPeople()
                .stream()
                .filter(person -> person.getGender().equalsIgnoreCase("female"))
                .count();

        System.out.println(females);

    }

    @Test
    public void min() throws IOException {

        final double yellowmin = MockData.getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);

        System.out.println(yellowmin);
    }

    @Test
    public void max() throws IOException {
        final double yellowmax = MockData.getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("Yellow"))
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);

        System.out.println(yellowmax);
    }

    @Test
    public void average() throws IOException {
        final double average = MockData.getCars().stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println(average);
    }

    @Test
    public void sum() throws IOException{
        final double totalstockprice = MockData.getCars().stream()
                .mapToDouble(Car::getPrice)
                .sum();

        System.out.println(totalstockprice);
    }

    @Test
    public void statstics() throws IOException{

        final List<Car> cars = MockData.getCars();

        DoubleSummaryStatistics doubleSummaryStatistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();

        System.out.println(doubleSummaryStatistics);
        System.out.println(doubleSummaryStatistics.getMax());
        System.out.println(doubleSummaryStatistics.getMin());
        System.out.println(doubleSummaryStatistics.getAverage());
        System.out.println(doubleSummaryStatistics.getCount());
        System.out.println(doubleSummaryStatistics.getSum());
    }

}
