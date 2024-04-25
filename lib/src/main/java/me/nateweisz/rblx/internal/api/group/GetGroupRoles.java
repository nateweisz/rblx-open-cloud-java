package me.nateweisz.rblx.internal.api.group;

import me.nateweisz.rblx.internal.RequestBuilder;
import me.nateweisz.rblx.internal.api.Request;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public record GetGroupRoles(String group, Optional<String> maxPageSize, Optional<String> pageToken) implements Request {
	@Override
	public RequestBuilder build() {
		StringBuilder endpoint = new StringBuilder("/v2/groups/%s/roles".formatted(group));
		Map<String, String> queryParams = new HashMap<>();
		maxPageSize.ifPresent(val -> queryParams.put("maxPageSize", val));
		pageToken.ifPresent(val -> queryParams.put("pageToken", val));

		if (!queryParams.isEmpty()) {
			endpoint.append("?");

			for (int i = 0; i < queryParams.size(); i++) {
				Map.Entry<String, String> set = queryParams.entrySet().stream().toList().get(i);
				endpoint.append("%s=%s".formatted(set.getKey(), set.getValue()));

				if (i != queryParams.size() - 1) {
					endpoint.append("&");
				}
			}
		}

		return new RequestBuilder(endpoint.toString()).get();
	}
}
