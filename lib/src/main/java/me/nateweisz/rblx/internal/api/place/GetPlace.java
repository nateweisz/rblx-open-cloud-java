package me.nateweisz.rblx.internal.api.place;

import me.nateweisz.rblx.internal.RequestBuilder;
import me.nateweisz.rblx.internal.api.Request;

public record GetPlace(
        String universe,
        String place
) implements Request {
    @Override
    public RequestBuilder build() {
        return new RequestBuilder("/v2/universes/%s/places/%s".formatted(universe, place))
                .get();
    }
}
