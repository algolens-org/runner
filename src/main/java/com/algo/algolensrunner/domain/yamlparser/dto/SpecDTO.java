package com.algo.algolensrunner.domain.yamlparser.dto;

import com.algo.algolensrunner.domain.yamlparser.dto.arrays.ArraysDTO;
import com.algo.algolensrunner.domain.yamlparser.dto.patterns.PatternDTO;
import com.algo.algolensrunner.domain.yamlparser.dto.variables.VariablesDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <h2>SpecDTO</h2>
 *
 * <p>generator를 위한 전체 규칙 정의 객체.</p>
 * <p><b>구성</b></p>
 * <ul>
 *   <li>{@link #variables} : 스칼라 변수 정의 리스트</li>
 *   <li>{@link #arrays}    : 배열 구조 정의 리스트</li>
 *   <li>{@link #patterns}  : 패턴(중첩 가능) 정의 리스트</li>
 *   <li>{@link #print}     : 출력 포맷(변수명·리터럴) 리스트</li>
 * </ul>
 */
@Getter @Setter
public class SpecDTO {

    List<VariablesDTO> variables;
    List<ArraysDTO> arrays;
    List<PatternDTO> patterns;
    /** 출력 순서를 지정하는 토큰 목록 */
    List<String> print;
}