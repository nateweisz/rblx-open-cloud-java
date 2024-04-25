package me.nateweisz.rblx.internal.api.creatorstore;

import me.nateweisz.rblx.api.models.CreatorStoreProduct;
import me.nateweisz.rblx.internal.RequestBuilder;
import me.nateweisz.rblx.internal.api.Request;

public record CreateCreatorStoreProduct(CreatorStoreProduct product) implements Request {
	@Override
	public RequestBuilder build() {
		return new RequestBuilder("/v2/creator-store-products").post(product);
	}
}
