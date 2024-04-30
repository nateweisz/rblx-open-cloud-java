package me.nateweisz.rblx.internal.auth;

import java.net.http.HttpRequest;

public interface IAuthProvider {
    void inject(HttpRequest.Builder requestBuilder);
}
