package streamapi.lectures;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import streamapi.beans.Car;
import streamapi.beans.Person;
import streamapi.beans.PersonDTO;
import streamapi.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Lecture5 {

    @Test
    public void understandingFilter() throws IOException {

        ImmutableList<Car> cars = MockData.getCars() ;

        final Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

        final List<Car> cheapcars = cars.stream().filter(carPredicate).collect(Collectors.toList());

        cheapcars.forEach(System.out::println);
        System.out.println(cheapcars.size());
    }


    @Test
    public void ourFirstMapping() throws IOException {

        // Transform one data type to another data type.
        final List<Person> people = MockData.getPeople();

        final Function<Person, PersonDTO> personPersonDTOFunction = person -> {
            PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
            return dto;
        };

        final List<PersonDTO> convertedDto = people.stream().map(personPersonDTOFunction).collect(Collectors.toList());

        // Can also use the method reference
        final Stream<PersonDTO> usingmethodreference = people.stream().map(PersonDTO::map);

        convertedDto.forEach(System.out::println);
        usingmethodreference.forEach(System.out::println);

        assertThat(convertedDto).hasSize(1000) ;

        System.out.println(convertedDto);

    }


}
