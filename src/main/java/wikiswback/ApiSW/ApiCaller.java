package wikiswback.ApiSW;

import jakarta.json.JsonObject;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import static jakarta.json.Json.createReader;

@Component
public class ApiCaller {

    public JsonObject getBuilder(String path, String searchQuery) throws Exception {
        HttpGet httpGet;
        if (searchQuery == null) {
            httpGet = new HttpGet("https://swapi.dev/api/" + path + "/");
        } else {
            httpGet = new HttpGet("https://swapi.dev/api/" + path + "/?search=" + searchQuery);
        }
        return getRequest(httpGet);
    }

    public JsonObject getRequest(HttpGet getRequest) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        getRequest.addHeader("accept", "application/json");
        HttpResponse response = httpClient.execute(getRequest);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed: HTTP error code: " + response.getStatusLine().getStatusCode());
        }

        try (InputStream contentStream = response.getEntity().getContent()) {
            String json = IOUtils.toString(contentStream, StandardCharsets.UTF_8);
            return deserialize(json);
        }
    }

    public JsonObject deserialize(String json) {
        return createReader(new StringReader(json)).readObject();
    }

    public JsonObject innerRequest(String uri) throws Exception {
        return getRequest(new HttpGet(uri));
    }
}
