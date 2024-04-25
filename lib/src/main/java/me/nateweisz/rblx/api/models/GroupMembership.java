package me.nateweisz.rblx.api.models;

public record GroupMembership(
        String path,
        String createTime,
        String updateTime,
        String user,
        String role
) {
}
