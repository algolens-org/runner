package com.algo.algolensrunner.domain.yamlparser.dto.arrays;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/** 배열 요소 정의 */
@Getter @Setter
public class ElementDTO {

    String kind;                 // scalar | enum 등
    /** 숫자형 타입(int, long…) */
    @com.fasterxml.jackson.annotation.JsonProperty("numeric_type")
    String numericType;
    String min;
    String max;
    java.util.List<Object> pool; // enum/셋형 값
}
