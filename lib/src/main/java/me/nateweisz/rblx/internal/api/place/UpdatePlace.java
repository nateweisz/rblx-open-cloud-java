package me.nateweisz.rblx.internal.api.place;

import me.nateweisz.rblx.api.models.Place;
import me.nateweisz.rblx.internal.RequestBuilder;
import me.nateweisz.rblx.internal.api.Request;

public record UpdatePlace(
        String universe,
        String place,
        String updateMask,
        Place placeObj
) implements Request {
    @Override
    public RequestBuilder build() {
        return new RequestBuilder("/v2/universes/%s/places/%s?updateMask=%s".formatted(universe, place, updateMask)).patch(placeObj);
    }
}
