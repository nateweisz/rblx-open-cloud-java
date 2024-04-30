package me.nateweisz.rblx.api;

import me.nateweisz.rblx.api.models.CreatorStoreProduct;
import me.nateweisz.rblx.api.models.Group;
import me.nateweisz.rblx.api.models.GroupShout;
import me.nateweisz.rblx.internal.RequestFactory;
import me.nateweisz.rblx.internal.api.creatorstore.CreateCreatorStoreProduct;
import me.nateweisz.rblx.internal.api.creatorstore.GetCreatorStoreProduct;
import me.nateweisz.rblx.internal.api.creatorstore.UpdateCreatorStoreProduct;
import me.nateweisz.rblx.internal.api.group.GetGroundShout;
import me.nateweisz.rblx.internal.api.group.GetGroup;
import me.nateweisz.rblx.internal.auth.IAuthProvider;
import me.nateweisz.rblx.internal.auth.TokenAuthProvider;

import java.io.IOException;

public class Roblox {
    private final RequestFactory requestFactory;

	private Roblox(IAuthProvider authProvider) {
        this.requestFactory = new RequestFactory(authProvider);
	}

	public CreatorStoreProduct createCreatorStoreProduct(CreatorStoreProduct product) throws IOException, InterruptedException {
		return requestFactory.sendAndParse(new CreateCreatorStoreProduct(product), CreatorStoreProduct.class);
	}

	public CreatorStoreProduct getCreatorStoreProduct(String productId) throws IOException, InterruptedException {
		return requestFactory.sendAndParse(new GetCreatorStoreProduct(productId), CreatorStoreProduct.class);
	}

	public CreatorStoreProduct updateCreatorStoreProduct(String productId, String updateMask, boolean allowMissing, CreatorStoreProduct product) throws IOException, InterruptedException {
		return requestFactory.sendAndParse(new UpdateCreatorStoreProduct(productId, updateMask, allowMissing, product), CreatorStoreProduct.class);
	}

	public Group getGroup(String groupId) throws IOException, InterruptedException {
		return requestFactory.sendAndParse(new GetGroup(groupId), Group.class);
	}

	public GroupShout getGroupShout(String groupId) throws IOException, InterruptedException {
		return requestFactory.sendAndParse(new GetGroundShout(groupId), GroupShout.class);
	}


	public static Roblox of(String authToken) {
		return new Roblox(new TokenAuthProvider(authToken));
	}
}
