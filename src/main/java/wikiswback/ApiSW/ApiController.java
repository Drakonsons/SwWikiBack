package wikiswback.ApiSW;



import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import wikiswback.User.UserEntity;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final ApiCaller apiCaller;

    @GetMapping("/films")
    public String apiCallFilms() throws Exception {
       return apiCaller.getBuilder("films", null);
    }

    @GetMapping("/people")
    public String apiCallPeople() throws Exception {
       return apiCaller.getBuilder("people", null);
    }

    @GetMapping("/planets")
    public String apiCallPlanets() throws Exception {
        return apiCaller.getBuilder("planets", null);
    }

    @GetMapping("/species")
    public String apiCallSpecies() throws Exception {
        return apiCaller.getBuilder("species", null);
    }

    @GetMapping("/starships")
    public String apiCallStarships() throws Exception {
        return apiCaller.getBuilder("starships", null);
    }

    @GetMapping("/vehicles")
    public String apiCallVehicles() throws Exception {
        return apiCaller.getBuilder("vehicles", null);
    }

    @GetMapping("/films/{id}")
    public String apiCallFilmsId(@PathVariable String id) throws Exception {
        return apiCaller.getBuilder("films", id);
    }

    @GetMapping("/people/{id}")
    public String apiCallPeopleId(@PathVariable String id) throws Exception {
        return apiCaller.getBuilder("people", id);
    }

    @GetMapping("/planets/{id}")
    public String apiCallPlanetsId(@PathVariable String id) throws Exception {
        return apiCaller.getBuilder("planets", id);
    }

    @GetMapping("/species/{id}")
    public String apiCallSpeciesId(@PathVariable String id) throws Exception {
        return apiCaller.getBuilder("species", id);
    }

    @GetMapping("/starships/{id}")
    public String apiCallStarshipsId(@PathVariable String id) throws Exception {
        return apiCaller.getBuilder("starships", id);
    }

    @GetMapping("/vehicles/{id}")
    public String apiCallVehiclesId(@PathVariable String id) throws Exception {
        return apiCaller.getBuilder("vehicles", id);
    }

}
