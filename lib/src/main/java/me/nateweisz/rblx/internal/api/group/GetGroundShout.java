package me.nateweisz.rblx.internal.api.group;

import me.nateweisz.rblx.internal.RequestBuilder;
import me.nateweisz.rblx.internal.api.Request;

public record GetGroundShout(
        String group
) implements Request {
    @Override
    public RequestBuilder build() {
        return new RequestBuilder("/v2/groups/%s/shout".formatted(group))
                .get();
    }
}
