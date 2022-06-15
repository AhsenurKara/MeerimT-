package httpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Test;
import pojo.game_of_thrones.*;

import java.io.IOException;
import java.util.List;

public class DeserializationWithPojo {

    @Test
    public void namesFromGOT() throws IOException {
        HttpResponse response = HttpClientUtils.getGetResponse("https://api.got.show/api/book/characters");

        ObjectMapper objectMapper = new ObjectMapper();
        CharacterPojo[] characters = objectMapper.readValue(response.getEntity().getContent(), CharacterPojo[].class);

        for (CharacterPojo character : characters) {
            System.out.println(character.getName());
        }
    }

    @Test
    public void housesFromGOT() throws IOException {
        HttpResponse response = HttpClientUtils.getGetResponse("https://api.got.show/api/book/houses");

        ObjectMapper objectMapper = new ObjectMapper();
        HousesPojo[] houses = objectMapper.readValue(response.getEntity().getContent(), HousesPojo[].class);

        for (HousesPojo house : houses) {
            System.out.println(house.getWords());
        }

    }

    @Test
    public void mapCharactersFromGOT() throws IOException {
        HttpResponse response = HttpClientUtils.getGetResponse("https://api.got.show/api/map/characters");

        ObjectMapper objectMapper = new ObjectMapper();
        MapCharacterPojo books = objectMapper.readValue(response.getEntity().getContent(), MapCharacterPojo.class);

        for (MapCharacterPojo1 book : books.getData()) {
            System.out.println(book.getTitles());
        }
    }

    @Test
    public void locationsCharactersFromGOT() throws IOException {
        HttpResponse response = HttpClientUtils.getGetResponse("https://api.got.show/api/book/characterlocations");

        ObjectMapper objectMapper = new ObjectMapper();
        CharacterLocationsPojo[] locations = objectMapper.readValue(response.getEntity().getContent(), CharacterLocationsPojo[].class);

        for (CharacterLocationsPojo location : locations) {
            System.out.println(location.getLocations());
        }
    }
//    @Test
//    public void nameCharactersFromGOT() throws IOException {
//        HttpResponse response = HttpClientUtils.getGetResponse("https://api.got.show/api/book/characters");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        CharacterPojo[] names = objectMapper.readValue(response.getEntity().getContent(), CharacterPojo[].class);
//
//       // for (CharacterPojo name : names) {
//            System.out.println(getClass().getName());
        }
