package streamapi.mockdata;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import streamapi.beans.Car;
import streamapi.beans.Person;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MockData {

   public static ImmutableList<Person> getPeople() throws IOException {

        InputStream inputStream = Resources.getResource("people.json").openStream() ;

        String json = IOUtils.toString(inputStream) ;

        Type listType = new TypeToken<ArrayList<Person>>(){}.getType() ; // Anonymous Class

       List<Person> people =new Gson().fromJson(json, listType) ;

        return  ImmutableList.copyOf(people);
   }

    public static ImmutableList<Car> getCars() throws IOException {

        InputStream inputStream = Resources.getResource("cars.json").openStream();

        String json = IOUtils.toString(inputStream);

        Type listType = new com.google.common.reflect.TypeToken<ArrayList<Car>>() {
        }.getType();

        List<Car> cars = new Gson().fromJson(json, listType);

        return ImmutableList.copyOf(cars);
    }

}
