package me.nateweisz.rblx.api.models;

import java.util.List;
import java.util.Optional;

public record CreatorStoreProduct(
   String path,
   String displayName,
   String description,
   Money basePrice,
   Money purchasePrice,
   boolean published,
   List<Restriction> restrictions,
   boolean purchasable,
   // it can be one of the following
   Optional<String> modelAssetId,
   Optional<String> pluginAssetId,
   Optional<String> audioAssetId,
   Optional<String> decalAssetId,
   Optional<String> meshPartAssetId,
   Optional<String> videoAssetId,
   // it can be one of the following
   Optional<String> userSeller,
   Optional<String> groupSeller
) {

    enum Restriction {
        RESTRICTION_UNSPECIFIED,
        SOLD_ITEM_RESTRICTED,
        SELLER_TEMPORARILY_RESTRICTED,
        SELLER_PERMANENTLY_RESTRICTED,
        SELLER_NO_LONGER_ACTIVE
    }
}
