package com.candi.animalia.util;

public record SearchCriteria(
        String key,
        String operation,
        Object value
) {
}
