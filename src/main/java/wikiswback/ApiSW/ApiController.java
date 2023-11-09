package wikiswback.ApiSW;

import jakarta.json.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final ApiCaller apiCaller;

    @GetMapping
    public JsonObject apiCall() throws Exception {
       return apiCaller.getBuilder("films", null);
    }

}
