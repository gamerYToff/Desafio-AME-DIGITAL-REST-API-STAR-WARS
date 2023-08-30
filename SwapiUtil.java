package com.br.swapiapi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.concurrent.atomic.AtomicReference;

public class SwapiUtil {

    private static final String url = "https://swapi.dev/api/planets/?search=";

    public static Integer getPlanetByName(String nome) {
        URI urlPlanets = URI.create(url + nome);
        AtomicReference<Integer> films = new AtomicReference<>();
        WebClient.RequestHeadersSpec<?> webFlux = WebClient.create().get().uri(urlPlanets);
        String response = webFlux.retrieve().bodyToMono(String.class).block();
        JsonArray results = new Gson().fromJson(response, JsonObject.class).get("results").getAsJsonArray();
        for (JsonElement element : results) {
            JsonArray listFilms = element.getAsJsonObject().getAsJsonArray("films");
            if (listFilms != null)
                return listFilms.size();
        }
        return 0;
    }
}
