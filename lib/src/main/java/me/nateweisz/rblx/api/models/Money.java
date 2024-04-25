package me.nateweisz.rblx.api.models;

public record Money(
        String currencyCode,
        Quantity quantity
) {
    record Quantity(
            int significand, // ex: 1799
            int exponent // -2
            // 17.99
    ) {}
}
