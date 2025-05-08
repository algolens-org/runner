package com.algo.algolensrunner.domain.yamlparser.dto.patterns;

import lombok.Getter;
import lombok.Setter;

/** 패턴 반복 제약조건 */
@Getter @Setter
public class RepeatConstraintsDTO {

    String structure;    // 배열/패턴 이름
    String elementName;  // 요소 변수명
    String min;          // 반복 최소
    String max;          // 반복 최대
}
