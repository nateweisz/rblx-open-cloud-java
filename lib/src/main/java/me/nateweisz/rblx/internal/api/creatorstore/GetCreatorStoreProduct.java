package me.nateweisz.rblx.internal.api.creatorstore;

import me.nateweisz.rblx.internal.RequestBuilder;
import me.nateweisz.rblx.internal.api.Request;

public record GetCreatorStoreProduct(String creatorStoreProduct) implements Request {
	@Override
	public RequestBuilder build() {
		return new RequestBuilder("/v2/creator-store-products/%s".formatted(creatorStoreProduct)).get();
	}
}
