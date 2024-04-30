package me.nateweisz.rblx.internal.api.universe;

import me.nateweisz.rblx.internal.RequestBuilder;
import me.nateweisz.rblx.internal.api.Request;

public record RestartUniverseServers(
        String universe
) implements Request {
    @Override
    public RequestBuilder build() {
        return new RequestBuilder("/v2/universes/%s:restartServers".formatted(universe))
                .post(new Object());
    }
}
