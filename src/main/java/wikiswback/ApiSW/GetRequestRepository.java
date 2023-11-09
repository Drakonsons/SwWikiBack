package wikiswback.ApiSW;

import jakarta.json.JsonObject;
import org.apache.http.client.ResponseHandler;

public class GetRequestRepository {

    private final ApiCaller apiCaller;

    public GetRequestRepository(ApiCaller apiCaller, ResponseHandler caller) {
        this.apiCaller = apiCaller;
    }

    public JsonObject getAll(String path, String searchQuery) {
        JsonObject jsonObject = null;
        try {
            jsonObject = apiCaller.getBuilder(path, searchQuery);
        } catch (Exception ignored) {
        }
        return jsonObject;
    }

    public JsonObject getOne(String path, String searchQuery) {
        JsonObject jsonObject = null;
        try {
            jsonObject = apiCaller.getBuilder(path, searchQuery);
        } catch (Exception ignored) {
        }
        return jsonObject;
    }

    public JsonObject innerRequest(String uri) {
        JsonObject jsonObject = null;
        try {
            jsonObject = apiCaller.innerRequest(uri);
        } catch (Exception ignored) {
        }
        return jsonObject;
    }
}
