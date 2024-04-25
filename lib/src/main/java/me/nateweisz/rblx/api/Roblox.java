package me.nateweisz.rblx.api;

import me.nateweisz.rblx.internal.auth.IAuthProvider;
import me.nateweisz.rblx.internal.auth.TokenAuthProvider;

public class Roblox {
	private final IAuthProvider authProvider;

	private Roblox(IAuthProvider authProvider) {
		this.authProvider = authProvider;
	}

	public static Roblox of(String authToken) {
		return new Roblox(new TokenAuthProvider(authToken));
	}
}
