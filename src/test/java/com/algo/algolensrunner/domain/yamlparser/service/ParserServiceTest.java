package com.algo.algolensrunner.domain.yamlparser.service;

import com.algo.algolensrunner.domain.yamlparser.dto.SpecDTO;
import com.algo.algolensrunner.domain.yamlparser.dto.YamlDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;   // ✅ JUnit5 Assertions

/**
 * <h2>ParserServiceTest (JUnit 5)</h2>
 *
 * <p>{@link ParserService#createDTO(String)}가
 *   정상적인 YAML 파일을 {@link YamlDTO}로 변환(happy‑path)하는지 검증한다.</p>
 *
 * <p><b>검증 시나리오</b></p>
 * <ol>
 *   <li>DTO 객체가 <code>null</code>이 아님을 확인한다.</li>
 *   <li>두 번째 변수의 이름이 <code>"K"</code>인지 확인한다.</li>
 *   <li>첫 번째 패턴 몸체의 두 번째 변수 이름이 <code>"V"</code>인지 확인한다.</li>
 * </ol>
 *
 * <p>⚠️ YAML 스펙 구조가 변경되면 본 테스트도 함께 업데이트해야 한다.</p>
 */
class ParserServiceTest {              // ✅ JUnit5는 public 생략 가능

    private final ParserService parserService = new ParserService();

    /**
     * <p>정상 YAML → DTO 변환이 성공해야 한다.</p>
     *
     * @throws IOException YAML 파일을 읽지 못할 때 발생
     */
    @Test
    @DisplayName("createDTO()가 정상 YAML을 YamlDTO로 파싱한다")   // ✅ 가독성용
    void createDTO_parsesYamlIntoSpecDTO() throws IOException {
        // given
        String path = "src/main/resources/test/ParserServiceTest01.yaml";
        String yamlStr = Files.readString(Path.of(path));     // ✅ 파일 내용을 문자열로

        // when
        YamlDTO yamlDTO = parserService.createDTO(yamlStr);   // 그대로 전달
        SpecDTO specDTO = yamlDTO.getSpec();


        // then
        assertNotNull(specDTO, "specDTO should not be null");
        assertNotNull(yamlDTO.getUserCode(), "userCode should not be null");
        assertNotNull(yamlDTO.getSolutionCode(), "solutionCode should not be null");
        assertEquals("K", specDTO.getVariables().get(1).getName(),
                "Second variable name must be 'K'");
        assertEquals("V",
                specDTO.getPatterns()
                        .get(0).getBody().getVariables().get(1).getName(),
                "Variable 'V' expected in first pattern body");

    }
}
