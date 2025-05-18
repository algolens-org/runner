package com.algo.algolensrunner.domain.yamlparser.dto.arrays;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArraysDTO {

    String name;
    String length;          // 길이(정수·식·변수)
    RangeDTO range;         // 인덱스 범위(선택)
    ElementDTO element;     // 요소 타입·범위
    String order;           // asc, desc, random
    ConstraintsDTO constraints;
}
