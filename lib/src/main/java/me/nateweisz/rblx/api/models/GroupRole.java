package me.nateweisz.rblx.api.models;

public record GroupRole(
        String path,
        String createTime,
        String updateTime,
        String id,
        String displayName,
        int rank,
        int memberCount,
        Permissions permissions
) {
    record Permissions(
            boolean viewWallPosts,
            boolean createWallPosts,
            boolean deleteWallPosts,
            boolean viewGroupShout,
            boolean createGroupShout,
            boolean changeRank,
            boolean acceptRequests,
            boolean exileMembers,
            boolean manageRelationships,
            boolean viewAuditLog,
            boolean spendGroupFunds,
            boolean advertiseGroup,
            boolean createAvatarItems,
            boolean manageAvatarItems,
            boolean manageGroupUniverses,
            boolean viewUniverseAnalytics,
            boolean createApiKeys,
            boolean manageApiKeys
    ) {}

}
