package com.algo.algolensrunner.domain.yamlparser.dto.variables;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * <h2>VariablesDTO</h2>
 *
 * <p>단일 스칼라 변수의 생성 규칙.</p>
 */
@Getter @Setter
public class VariablesDTO {

    String name;           // 변수명
    String kind;           // variables
    String numericType;    // int, long, double …
    String min;            // 값 하한
    String max;            // 값 상한
    List<Object> pool;     // enum/셋형 값 목록
}