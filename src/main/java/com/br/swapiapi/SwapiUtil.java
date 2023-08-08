package com.br.swapiapi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class SwapiUtil {

    private static final String url = "https://swapi.dev/api/planets/?search=";

    public static Integer getPlanetByName(String nome) throws IOException {
        URL urlPlanets = new URL(url + nome);
        HttpURLConnection con = (HttpURLConnection) urlPlanets.openConnection();
        con.setRequestMethod("GET");
        int contagemDeFilmes = 0;
        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String linha;
            StringBuilder resposta = new StringBuilder();
            while ((linha = reader.readLine()) != null) {
                resposta.append(linha);
            }
            reader.close();
            Gson gson = new Gson();
            TypeToken<Map<String, Object>> tipoDeToken = new TypeToken<>() {};
            Map<String, Object> responseMap = gson.fromJson(resposta.toString(), tipoDeToken.getType());
            List<Map<String, Object>> results = (List<Map<String, Object>>) responseMap.get("results");
            if (!results.isEmpty()) {
                Map<String, Object> result = results.get(0);
                List<String> films = (List<String>) result.get("films");
                contagemDeFilmes = films.size();
            }
        }
        return contagemDeFilmes;
    }
}
