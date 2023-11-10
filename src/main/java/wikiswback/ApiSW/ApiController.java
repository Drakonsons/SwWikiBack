package wikiswback.ApiSW;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
       return apiCaller.getBuilder("people", "C-3PO");
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
        return apiCaller.getBuilder("starships", "x-wing");
    }

    @GetMapping("/vehicles")
    public String apiCallVehicles() throws Exception {
        return apiCaller.getBuilder("vehicles", null);
    }

}
