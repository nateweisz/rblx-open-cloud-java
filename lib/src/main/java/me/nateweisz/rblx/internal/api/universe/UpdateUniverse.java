package me.nateweisz.rblx.internal.api.universe;

import me.nateweisz.rblx.api.models.Universe;
import me.nateweisz.rblx.internal.RequestBuilder;
import me.nateweisz.rblx.internal.api.Request;

public record UpdateUniverse(
        String universe,
        String updateMask,
        Universe universeObj
) implements Request {
    @Override
    public RequestBuilder build() {
        return new RequestBuilder("/v2/universes/%s?updateMask=%s".formatted(universe, updateMask))
                .patch(universeObj);
    }
}
