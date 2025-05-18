package com.algo.algolensrunner.domain.yamlparser.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * <h2>YamlDTO</h2>
 *
 * <p>사용자가 작성한 YAML 스펙 파일을 역직렬화할 때
 *  최상위 루트 노드를 매핑하는 DTO.</p>
 *
 * <ul>
 *   <li>{@link #spec}  : 테스트케이스 생성 규칙(변수·배열·패턴 정의)</li>
 *   <li>{@link #solutionCode} : 정답 코드</li>
 *   <li>{@link #userCode}   : 유저의 제출 코드</li>
 * </ul>
 */
@Getter @Setter
public class YamlDTO {

    /** 테스트 스펙 정의 루트 */
    SpecDTO spec;

    /** 정답 코드 */
    String solutionCode;

    /** 제출 코드 */
    String userCode;
}