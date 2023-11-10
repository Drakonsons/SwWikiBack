package wikiswback.ApiSW;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ApiCaller {


    public String getBuilder(String path, String searchQuery) throws Exception {

        StringBuilder response = new StringBuilder();

        URL url;
        try {
            if (searchQuery == null) {
                url = new URL("https://swapi.dev/api/" + path + "/"); // on crée l'url
            } else {
                url = new URL("https://swapi.dev/api/" + path + "/?search=" + searchQuery); // on crée l'url avec la recherche
            }


            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // ouverture de la connexion

            connection.setRequestProperty("Accept", "application/json"); // on précise qu'on veut du json
            connection.setRequestMethod("GET"); // on précise qu'on veut faire un get

            int responseCode = connection.getResponseCode(); // on récupère le code de la réponse

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine; // on va lire la réponse ligne par ligne

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine); // on ajoute chaque ligne à la réponse
                }

                in.close();
            } else {
                response.append("La requête a échoué avec le code : ").append(responseCode); // on ajoute le code de la réponse à la réponse
            }

            connection.disconnect(); // on ferme la connexion

        } catch (Exception e) {
            e.printStackTrace(); // on affiche l'erreur
        }

        return response.toString(); // on retourne la réponse
    }
}