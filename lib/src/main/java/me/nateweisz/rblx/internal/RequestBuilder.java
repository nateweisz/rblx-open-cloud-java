package me.nateweisz.rblx.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpRequest;

public class RequestBuilder {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final HttpRequest.Builder requestBuilder;

    public RequestBuilder(String endpoint) {
        requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(Endpoints.V2_BASE_URL + endpoint));
    }

    public RequestBuilder get() {
        requestBuilder.GET();
        return this;
    }

    public RequestBuilder post(Object body) {
        try {
            requestBuilder
                    .setHeader("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(OBJECT_MAPPER.writeValueAsString(body)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return this;
    }



    public RequestBuilder patch(Object body) {
        try {
            requestBuilder
                    .setHeader("Content-Type", "application/json")
                    .method("PATCH", HttpRequest.BodyPublishers.ofString(OBJECT_MAPPER.writeValueAsString(body)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return this;
    }

    public RequestBuilder header(String key, String value) {
        requestBuilder.setHeader(key, value);
        return this;
    }
}
