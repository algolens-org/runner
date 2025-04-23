package com.algo.algolensrunner.domain.yamlparser.dto.variables;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class VariablesDTO {

    String name;
    String kind;
    String numericType;
    String min;
    String max;
    List<Object> pool;
}
