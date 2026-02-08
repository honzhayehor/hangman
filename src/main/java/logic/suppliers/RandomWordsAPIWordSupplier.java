package logic.suppliers;

import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.System;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class RandomWordsAPIWordSupplier implements WordSupplier {

    private final String BASE_URL;
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    public RandomWordsAPIWordSupplier() {
        this.BASE_URL = loadBaseUrl();
    }

    @Override
    public String supplyWords() {

        URI uri = URI.create(BASE_URL + randomInt);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.err.println("API returned status: " + response.statusCode());
                return "";
            }

            String jsonBody = response.body();
            if (jsonBody == null || jsonBody.isEmpty()) {
                return "";
            }

            List<String> l = objectMapper.readValue(jsonBody, new TypeReference<List<String>>() {});

            return WordSupplier.getRandomElement(l);

        } catch (IOException | InterruptedException e) {
            System.err.println("Request failed: " + e.getMessage());
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            return "";
        } catch (JacksonException e) {
            System.err.println("JSON parsing error: " + e.getMessage());
            return "";
        }
    }

    private String loadBaseUrl() {
        Properties p = new Properties();
        try (InputStream in = Files.newInputStream(Path.of("config.properties"))) {
            p.load(in);
            String url = p.getProperty("randomWords.baseUrl");
            if (url == null || url.isBlank()) {
                throw new IllegalStateException("randomWords.baseUrl is missing in config.properties");
            }
            return url;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read config.properties", e);
        }
    }
}
