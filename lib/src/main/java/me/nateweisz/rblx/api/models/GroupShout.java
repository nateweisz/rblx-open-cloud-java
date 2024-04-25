package me.nateweisz.rblx.api.models;

import java.util.Optional;

public record GroupShout(String path, String createTime, String updateTime, String content, Optional<String> poster) {
}
