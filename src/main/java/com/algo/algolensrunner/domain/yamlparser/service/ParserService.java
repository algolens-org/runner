package com.algo.algolensrunner.domain.yamlparser.service;

import com.algo.algolensrunner.domain.yamlparser.dto.SpecDTO;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertyUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * <h2>ParserService</h2>
 *
 * <p>YAML 스펙 파일을 {@link SpecDTO}로 역직렬화(deserialize)하는 서비스.</p>
 *
 * <ul>
 *   <li>스펙 오류를 조기에 탐지하기 위해 <b>SnakeYAML 2.4 권장 LoaderOptions</b>를 모두 적용한다.</li>
 *   <li>키 이름(snake_case)을 DTO 필드명(camelCase)으로 자동 변환하여
 *       YAML 작성 규칙과 자바 코딩 컨벤션을 동시에 만족한다.</li>
 * </ul>
 *
 * <p><b>사용 예</b></p>
 * <pre>{@code
 * ParserService parser = new ParserService();
 * SpecDTO spec = parser.createDTO("/src/main/resources/test/ParserServiceTest01.yaml");
 * }</pre>
 *
 * @author  hyunchang
 * @version 1.0 (2025-04-23)
 */
@Service
public class ParserService {

    /** SnakeYAML 인스턴스(스레드 안전성을 위해 불변 객체 하나만 생성해서 재사용). */
    private final Yaml yaml;

    // ======================================================================
    // 1. HELPER CLASS ---- 이름 변환기
    // ======================================================================

    /**
     * <p>snake_case → camelCase로 필드명을 변환하는 커스텀 {@link PropertyUtils}.</p>
     *
     * <p>SnakeYAML이 내부적으로 DTO 필드명을 탐색할 때 이 유틸리티를 사용하면
     * YAML 파일에서는 snake_case를, 자바 객체에서는 camelCase를
     * 각각 유지할 수 있어 가독성이 좋아진다.</p>
     */
    class SnakeToCamelUtils extends PropertyUtils {

        @Override
        public Property getProperty(Class<?> type, String name) {
            // 원본 키 값을 camelCase로 바꾼 뒤 부모 메서드에 위임
            return super.getProperty(type, toCamel(name));
        }

        /**
         * 밑줄(_) 구분 문자열을 camelCase로 변환한다.
         *
         * @param s 변환할 문자열
         * @return  camelCase 문자열
         */
        private String toCamel(String s) {
            StringBuilder sb = new StringBuilder();
            boolean upper = false;
            for (char c : s.toCharArray()) {
                if (c == '_') { upper = true; continue; }
                sb.append(upper ? Character.toUpperCase(c) : c);
                upper = false;
            }
            return sb.toString();
        }
    }

    // ======================================================================
    // 2. CONSTRUCTOR ---- LoaderOptions & Yaml 초기화
    // ======================================================================

    /**
     * 기본 생성자.
     * <p>생성 시점에 LoaderOptions와 커스텀 PropertyUtils를 한번만 초기화한다.</p>
     */
    public ParserService() {

        LoaderOptions opts = new LoaderOptions();
        // ▼▼▼ SnakeYAML 2.4 권장 옵션: 안전-보안 관련 설정 ▼▼▼
        opts.setAllowDuplicateKeys(false);      // 동일 키 허용❌ → 조기 오류 탐지
        opts.setMaxAliasesForCollections(50);   // YAML Billion Laughs 공격 방어
        opts.setNestingDepthLimit(50);          // 과도한 중첩 제한
        opts.setEnumCaseSensitive(false);       // enum 매핑 시 대소문자 구분 무시
        // ▲▲▲----------------------------------------------------▲▲▲

        Constructor cons = new Constructor(SpecDTO.class, opts);
        cons.setPropertyUtils(new SnakeToCamelUtils());   // snake→camel 변환기 주입
        this.yaml = new Yaml(cons);                       // 재사용 가능한 불변 객체
    }

    // ======================================================================
    // 3. BUSINESS METHOD ---- YAML → DTO
    // ======================================================================

    /**
     * 주어진 파일 경로에 있는 YAML 문서를 읽어 {@link SpecDTO}로 파싱한다.
     *
     * @param file 읽을 YAML 파일의 <b>절대/상대 경로</b>
     * @return     파싱된 {@link SpecDTO} 객체
     * @throws IOException <ul>
     *   <li>경로가 잘못되었거나 파일이 없는 경우</li>
     *   <li>파일을 읽을 수 없는 경우(권한 등)</li>
     * </ul>
     */
    public SpecDTO createDTO(String file) throws IOException {
        // 한 줄로 끝나는 단순 호출이라도 예외를 명시해두면 호출측이 명확히 인지할 수 있다.
        return yaml.load(Files.newInputStream(Path.of(file)));
    }
}
