package wikiswback.ApiSW;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

public class Printer {

    public Printer() {
    }

    private final ApiCaller apiCaller = new ApiCaller();

    public void printDetailsFilms(JsonArray results) {
        if (!results.isEmpty()) {
            for (int i = 0; i < results.size(); i++) {
                JsonObject film = results.getJsonObject(i);
                System.out.println("Title : " + film.getString("title"));
                System.out.println("Episode number : " + film.getInt("episode_id"));
                System.out.println("Opening crawl : " + film.getString("opening_crawl"));
                System.out.println("Director : " + film.getString("director"));
                System.out.println("Producer : " + film.getString("producer"));
                System.out.println("Release Date : " + film.getString("release_date"));

                JsonArray characters = film.getJsonArray("characters");
                System.out.println();
                System.out.println("Characters :");
                System.out.println();
                printSubCall("name", characters);
                System.out.println();

                JsonArray planets = film.getJsonArray("planets");
                System.out.println();
                System.out.println("Planets :");
                System.out.println();
                printSubCall("name", planets);
                System.out.println();

                JsonArray starships = film.getJsonArray("starships");
                System.out.println();
                System.out.println("Starships :");
                System.out.println();
                printSubCall("name", starships);
                System.out.println();

                JsonArray vehicles = film.getJsonArray("vehicles");
                System.out.println();
                System.out.println("Vehicles :");
                System.out.println();
                printSubCall("name", vehicles);
                System.out.println();

                JsonArray species = film.getJsonArray("species");
                System.out.println();
                System.out.println("Species :");
                System.out.println();
                printSubCall("name", species);
                System.out.println();

                System.out.println();
                System.out.println();
            }
        } else {
            System.out.println("Your search didn't get any results");
        }
    }

    public void printDetailsPlanets(JsonArray planetresults) {
        if (!planetresults.isEmpty()) {
            for (int i = 0; i < planetresults.size(); i++) {
                JsonObject planet = planetresults.getJsonObject(i);
                System.out.println("Planet : " + planet.getString("name"));
                System.out.println("Rotation Period : " + planet.getString("rotation_period"));
                System.out.println("Orbital Period : " + planet.getString("orbital_period"));
                System.out.println("Diameter : " + planet.getString("diameter"));
                System.out.println("Gravity : " + planet.getString("gravity"));
                System.out.println("Terrain : " + planet.getString("terrain"));
                System.out.println("Surface water : " + planet.getString("surface_water"));
                System.out.println("Population : " + planet.getString("population"));

                JsonArray residents = planet.getJsonArray("residents");
                System.out.println();
                System.out.println("Residents :");
                System.out.println();
                printSubCall("name", residents);
                System.out.println();

                JsonArray films = planet.getJsonArray("films");
                System.out.println();
                System.out.println("Films :");
                System.out.println();
                printSubCall("title", films);
                System.out.println();
            }
        } else {
            System.out.println("Your search didn't get any results");
        }
    }

    public void printDetailsStarships(JsonArray starshipresults) {
        if (!starshipresults.isEmpty()) {
            for (int i = 0; i < starshipresults.size(); i++) {
                JsonObject starship = starshipresults.getJsonObject(i);
                System.out.println("Name : " + starship.getString("name"));
                System.out.println("Model : " + starship.getString("model"));
                System.out.println("Manufacturer : " + starship.getString("manufacturer"));
                System.out.println("Cost in credits : " + starship.getString("cost_in_credits"));
                System.out.println("Length : " + starship.getString("length"));
                System.out.println("Max Atmosphering Speed : " + starship.getString("max_atmosphering_speed"));
                System.out.println("Crew : " + starship.getString("crew"));
                System.out.println("Passengers : " + starship.getString("passengers"));
                System.out.println("Cargo Capacity : " + starship.getString("cargo_capacity"));
                System.out.println("Consumables : " + starship.getString("consumables"));
                System.out.println("Hyperdrive Rating : " + starship.getString("hyperdrive_rating"));
                System.out.println("MGLT : " + starship.getString("MGLT"));
                System.out.println("Starship Class : " + starship.getString("starship_class"));

                JsonArray pilots = starship.getJsonArray("pilots");
                System.out.println();
                System.out.println("Pilots :");
                System.out.println();
                printSubCall("name", pilots);
                System.out.println();

                JsonArray films = starship.getJsonArray("films");
                System.out.println();
                System.out.println("Films :");
                System.out.println();
                printSubCall("title", films);
                System.out.println();
            }
        } else {
            System.out.println("Your search didn't get any results");
        }
    }

    public void printDetailsVehicles(JsonArray vehicleResults) {
        if (!vehicleResults.isEmpty()) {
            for (int i = 0; i < vehicleResults.size(); i++) {
                JsonObject vehicle = vehicleResults.getJsonObject(i);
                System.out.println("Name : " + vehicle.getString("name"));
                System.out.println("Model : " + vehicle.getString("model"));
                System.out.println("Manufacturer : " + vehicle.getString("manufacturer"));
                System.out.println("Cost in credits : " + vehicle.getString("cost_in_credits"));
                System.out.println("Length : " + vehicle.getString("length"));
                System.out.println("Max Atmosphering Speed : " + vehicle.getString("max_atmosphering_speed"));
                System.out.println("Crew : " + vehicle.getString("crew"));
                System.out.println("Passengers : " + vehicle.getString("passengers"));
                System.out.println("Cargo Capacity : " + vehicle.getString("cargo_capacity"));
                System.out.println("Consumables : " + vehicle.getString("consumables"));
                System.out.println("Vehicle Class : " + vehicle.getString("vehicle_class"));

                JsonArray pilots = vehicle.getJsonArray("pilots");
                System.out.println();
                System.out.println("Pilots :");
                System.out.println();
                printSubCall("name", pilots);
                System.out.println();

                JsonArray films = vehicle.getJsonArray("films");
                System.out.println();
                System.out.println("Films :");
                System.out.println();
                printSubCall("title", films);
                System.out.println();
            }
        } else {
            System.out.println("Your search didn't get any results");
        }
    }

    public void printDetailsSpecies(JsonArray speciesResults) {
        if (!speciesResults.isEmpty()) {
            for (int i = 0; i < speciesResults.size(); i++) {
                JsonObject species = speciesResults.getJsonObject(i);
                System.out.println("Name : " + species.getString("name"));
                System.out.println("Classification : " + species.getString("classification"));
                System.out.println("Designation : " + species.getString("designation"));
                System.out.println("Average Height : " + species.getString("average_height"));
                System.out.println("Average Lifespan : " + species.getString("average_lifespan"));
                System.out.println("Eye Colors : " + species.getString("eye_colors"));
                System.out.println("Hair Colors : " + species.getString("hair_colors"));
                System.out.println("Skin Color : " + species.getString("skin_colors"));
                System.out.println("Language : " + species.getString("language"));
                System.out.println("Homeworld : " + species.getString("homeworld"));
                System.out.println("People : " + species.getJsonArray("people"));
                System.out.println("Films : " + species.getJsonArray("films"));

                JsonArray people = species.getJsonArray("people");
                System.out.println();
                System.out.println("People :");
                System.out.println();
                printSubCall("name", people);
                System.out.println();

                JsonArray films = species.getJsonArray("films");
                System.out.println();
                System.out.println("Films :");
                System.out.println();
                printSubCall("title", films);
                System.out.println();
            }
        } else {
            System.out.println("Your search didn't get any results");
        }
    }

    public void printDetailsPeople(JsonArray peopleResults) {
        if (!peopleResults.isEmpty()) {
            for (int i = 0; i < peopleResults.size(); i++) {
                JsonObject people = peopleResults.getJsonObject(i);
                System.out.println("Name : " + people.getString("name"));
                System.out.println("Birth Year : " + people.getString("birth_year"));
                System.out.println("Eye Color : " + people.getString("eye_color"));
                System.out.println("Gender : " + people.getString("gender"));
                System.out.println("Hair Color : " + people.getString("hair_color"));
                System.out.println("Height : " + people.getString("height"));
                System.out.println("Mass : " + people.getString("mass"));
                System.out.println("Skin Color : " + people.getString("skin_color"));
                System.out.println("Homeworld : " + people.getString("homeworld"));
                System.out.println("Films : " + people.getJsonArray("films"));
                System.out.println("Species : " + people.getJsonArray("species"));
                System.out.println("Vehicles : " + people.getJsonArray("vehicles"));
                System.out.println("Starships : " + people.getJsonArray("starships"));

                JsonArray films = people.getJsonArray("films");
                System.out.println();
                System.out.println("Films :");
                System.out.println();
                printSubCall("title", films);
                System.out.println();

                JsonArray species = people.getJsonArray("species");
                System.out.println();
                System.out.println("Species :");
                System.out.println();
                printSubCall("name", species);
                System.out.println();

                JsonArray vehicles = people.getJsonArray("vehicles");
                System.out.println();
                System.out.println("Vehicles :");
                System.out.println();
                printSubCall("name", vehicles);
                System.out.println();
            }
        } else {
            System.out.println("Your search didn't get any results");
        }
    }

    private void printSubCall(String field, JsonArray jsonArray) {
        if (!jsonArray.isEmpty()) {
            for (int j = 0; j < jsonArray.size(); j++) {
                String uri = jsonArray.getString(j);
                JsonObject response = null;
                try {
                    response = apiCaller.innerRequest(uri);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println(field + " : " + response.getString(field));
            }
        } else {
            System.out.println("nothing here");
        }
    }
}
