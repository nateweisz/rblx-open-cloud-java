package me.nateweisz.rblx.internal.api.universe;

import me.nateweisz.rblx.internal.RequestBuilder;
import me.nateweisz.rblx.internal.api.Request;

public record GetUniverse(
        String universe
) implements Request {
    @Override
    public RequestBuilder build() {
        return new RequestBuilder("/v2/universes/%s".formatted(universe))
                .get();
    }
}
