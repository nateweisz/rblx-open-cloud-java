package me.nateweisz.rblx.api.models;

public record Group(
        String path,
        String createTime,
        String updateTime,
        String id,
        String displayName,
        String description,
        String owner,
        int memberCount,
        boolean publicEntryAllowed,
        boolean locked,
        boolean verified
) {
}
