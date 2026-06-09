package com.jio.subscription.payments.web;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import tools.jackson.databind.ObjectMapper;

/**
 * Implements the TMF {@code fields} query parameter (attribute selection / partial response). When
 * {@code fields} is supplied, only the requested top-level attributes are returned, alongside the
 * mandatory identity/polymorphism attributes that TMF always includes.
 */
public final class PartialResponse {

    private static final Set<String> ALWAYS_INCLUDED = Set.of("id", "href", "@type", "@baseType", "@schemaLocation");

    private PartialResponse() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T apply(ObjectMapper mapper, T dto, String fields, Class<T> type) {
        if (dto == null || fields == null || fields.isBlank()) {
            return dto;
        }
        Set<String> keep = new LinkedHashSet<>(ALWAYS_INCLUDED);
        for (String field : fields.split(",")) {
            if (!field.isBlank()) {
                keep.add(field.trim());
            }
        }
        Map<String, Object> attributes = mapper.convertValue(dto, Map.class);
        attributes.keySet().retainAll(keep);
        return mapper.convertValue(attributes, type);
    }
}
