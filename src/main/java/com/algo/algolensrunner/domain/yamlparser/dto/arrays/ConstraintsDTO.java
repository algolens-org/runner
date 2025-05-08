package com.algo.algolensrunner.domain.yamlparser.dto.arrays;

import lombok.Getter;
import lombok.Setter;

/** 배열 전역 제약조건 */
@Getter @Setter
public class ConstraintsDTO {
    String unique;   // 요소 유일성 여부
    String offset;   // 인덱스 오프셋
    String sumMax;   // 합계 상한
    String sumMin;   // 합계 하한
}