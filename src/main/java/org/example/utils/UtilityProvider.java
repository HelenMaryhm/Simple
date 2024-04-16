package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public enum UtilityProvider {
    ;

    public static ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

}
