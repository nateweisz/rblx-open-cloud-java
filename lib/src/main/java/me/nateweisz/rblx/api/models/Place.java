package me.nateweisz.rblx.api.models;

public record Place(
        String path,
        String createTime,
        String updateTime,
        String displayName,
        String description,
        int serverSize
) {
}
