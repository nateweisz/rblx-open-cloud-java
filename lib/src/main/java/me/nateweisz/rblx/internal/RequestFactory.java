package me.nateweisz.rblx.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.nateweisz.rblx.api.exceptions.*;
import me.nateweisz.rblx.internal.api.Request;
import me.nateweisz.rblx.internal.auth.IAuthProvider;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class RequestFactory {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final HttpClient client;
    private final IAuthProvider authProvider;

    public RequestFactory(IAuthProvider authProvider) {
        client = HttpClient.newBuilder()
                .build();
        this.authProvider = authProvider;
    }

    public <T> T sendAndParse(Request request, Class<T> clazz) throws IOException, InterruptedException, RobloxException {
        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() != 200) {
            RobloxResponse parsed = OBJECT_MAPPER.readValue(response.body(), RobloxResponse.class);

            switch (response.statusCode()) {
                case 400 -> throw new InvalidArgumentRobloxException(parsed.message());
                case 403 -> throw new PermissionDeniedRobloxException(parsed.message());
                case 404 -> throw new NotFoundRobloxException(parsed.message());
                case 409 -> throw new AbortedRobloxException(parsed.message());
                case 429 -> throw new ResourceExhaustedRobloxException(parsed.message());
                case 499 -> throw new CancelledRobloxException(parsed.message());
                case 500 -> throw new InternalRobloxException(parsed.message());
                case 501 -> throw new NotImplementedRobloxException(parsed.message());
                case 503 -> throw new UnavailableRobloxException(parsed.message());
                default -> throw new RobloxException("Unknown status code: " + response.statusCode());
            }
        }

        return OBJECT_MAPPER.readValue(response.body(), clazz);
    }

    private HttpResponse<String> sendRequest(Request request) throws IOException, InterruptedException {
        HttpRequest.Builder req = request.build().getRequestBuilder();
        authProvider.inject(req);


        return client.send(
                req.build(),
                HttpResponse.BodyHandlers.ofString()
        );
    }
}
