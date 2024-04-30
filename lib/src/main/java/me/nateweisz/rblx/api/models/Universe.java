package me.nateweisz.rblx.api.models;

import java.util.Optional;

public record Universe(
        String path,
        String createTime,
        String updateTime,
        String displayName,
        String description,
        Visibility visibility,
        SocialMedia facebookSocialLink,
        SocialMedia twitterSocialLink,
        SocialMedia youtubeSocialLink,
        SocialMedia twitchSocialLink,
        SocialMedia discordSocialLink,
        SocialMedia robloxGroupSocialLink,
        SocialMedia guildedSocialLink,
        boolean voiceChatEnabled,
        AgeRating ageRating,
        int privateServerPriceRobux,
        boolean desktopEnabled,
        boolean mobileEnabled,
        boolean tabletEnabled,
        boolean consoleEnabled,
        boolean vrEnabled,
        Optional<String> user,
        Optional<String> group
        ) {
    enum Visibility {
        VISIBILITY_UNSPECIFIED,
        PUBLIC,
        PRIVATE
    }

    enum AgeRating {
        AGE_RATING_UNSPECIFIED, AGE_RATING_ALL, AGE_RATING_9_PLUS, AGE_RATING_13_PLUS, AGE_RATING_17_PLUS
    }

    record SocialMedia(
       String title,
       String uri
    ) {}
}
