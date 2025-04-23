package com.algo.algolensrunner.domain.yamlparser.dto.arrays;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArraysDTO {

    String name;
    String length;
    RangeDTO range;
    ElementDTO element;
    String order;
    ConstraintsDTO constraints;
}
