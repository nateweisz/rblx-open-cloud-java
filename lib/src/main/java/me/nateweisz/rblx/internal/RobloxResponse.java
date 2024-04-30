package me.nateweisz.rblx.internal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RobloxResponse(
        String code,
        String message
) {
}