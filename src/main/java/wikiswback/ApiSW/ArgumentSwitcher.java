package wikiswback.ApiSW;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.ResponseHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RequiredArgsConstructor
public class ArgumentSwitcher {

    private static final ApiCaller apiCalls = new ApiCaller();
    private ApiCaller apiCaller;
    private final GetRequestRepository repository = new GetRequestRepository(apiCalls, (ResponseHandler) apiCaller);
    private final Printer printer;

    public ArgumentSwitcher(BufferedReader reader, Printer printer) {
        this.printer = printer;
    }

    public void switchCommand(String command, String searchQuery) {
        JsonObject jsonObject = repository.getAll(command, searchQuery);

        switch (command) {
            case "films":
                JsonArray filmResults = jsonObject.getJsonArray("results");
                printer.printDetailsFilms(filmResults);
                break;
            case "planets":
                JsonArray planetResults = jsonObject.getJsonArray("results");
                printer.printDetailsPlanets(planetResults);
                break;
            case "starships":
                JsonArray starshipResults = jsonObject.getJsonArray("results");
                printer.printDetailsStarships(starshipResults);
                break;
            case "vehicles":
                JsonArray vehicleResults = jsonObject.getJsonArray("results");
                printer.printDetailsVehicles(vehicleResults);
                break;
            case "species":
                JsonArray speciesResults = jsonObject.getJsonArray("results");
                printer.printDetailsSpecies(speciesResults);
                break;
            case "people":
                JsonArray peopleResults = jsonObject.getJsonArray("results");
                printer.printDetailsPeople(peopleResults);
                break;
            default:
                System.out.println(command + " is not an available command");
                break;
        }
    }
}
