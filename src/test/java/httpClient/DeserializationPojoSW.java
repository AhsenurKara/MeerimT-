package httpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.junit.Test;
import pojo.game_of_thrones.CharacterPojo;
import pojo.star_wars.PeoplePojo;
import pojo.star_wars.PlanetsPojo;
import pojo.star_wars.StarshipsPojo;

import java.io.IOException;

public class DeserializationPojoSW {

    @Test
    public void planetsFromSW() throws IOException {
        HttpResponse response = HttpClientUtils.getGetResponse("https://swapi.dev/api/planets/?page=1");

        ObjectMapper objectMapper = new ObjectMapper();
        PlanetsPojo[] characters = objectMapper.readValue(response.getEntity().getContent(), PlanetsPojo[].class);

        for (PlanetsPojo character : characters) {
            System.out.println(character.getName());
        }

    }
    @Test
    public void peopleFromSW() throws IOException {
        HttpResponse response = HttpClientUtils.getGetResponse("https://swapi.dev/api/people/?page=1 ");

        ObjectMapper objectMapper = new ObjectMapper();
        PeoplePojo[] people = objectMapper.readValue(response.getEntity().getContent(), PeoplePojo[].class);

        for (PeoplePojo human : people) {
            System.out.println(human.getGender());
        }
    }
   @Test
     public void starshipsFromSW() throws IOException{
        HttpResponse response=HttpClientUtils.getGetResponse("https://swapi.dev/api/starships/?page=1");

        ObjectMapper objectMapper=new ObjectMapper();
       StarshipsPojo[] starships = objectMapper.readValue(response.getEntity().getContent(), StarshipsPojo[].class);

       for (StarshipsPojo starship : starships) {
           System.out.println(starship.getResults());
        }
        }
}



