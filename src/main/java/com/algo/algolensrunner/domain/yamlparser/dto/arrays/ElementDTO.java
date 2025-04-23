package com.algo.algolensrunner.domain.yamlparser.dto.arrays;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ElementDTO {

    String kind;
    @JsonProperty("numeric_type")
    String numericType;
    String min;
    String max;
    List<Object> pool;
}
