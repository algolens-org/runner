package com.algo.algolensrunner.domain.yamlparser.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * <h2>PrintItemDTO</h2>
 *
 * <p>출력 포맷의 각 항목을 명시한다.<br>
 *   예) <code>{"type": "literal", "name": " "}</code></p>
 */
@Getter @Setter
public class PrintItemDTO {

    /** literal | variable | array 등 */
    String type;
    /** 출력 대상 식별자(literal일 경우 값 자체) */
    String name;
}