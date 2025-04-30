package com.algo.algolensrunner.domain.yamlparser.service;

import com.algo.algolensrunner.domain.yamlparser.dto.SpecDTO;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * <h2>ParserServiceTest</h2>
 *
 * <p>{@link ParserService#createDTO(String)} 가
 *   정상적인 YAML 파일을 {@link SpecDTO} 로 변환(happy-path)하는지 검증한다.</p>
 *
 * <p><b>검증 시나리오</b></p>
 * <ol>
 *   <li>DTO 객체가 <code>null</code> 이 아님을 확인한다.</li>
 *   <li>두 번째 변수의 이름이 <code>"K"</code> 인지 확인한다.</li>
 *   <li>첫 번째 패턴 몸체의 두 번째 변수 이름이 <code>"V"</code> 인지 확인한다.</li>
 * </ol>
 *
 * <p>⚠️ YAML 스펙 구조가 변경되면 본 테스트도 함께 업데이트해야 한다.</p>
 */
public class ParserServiceTest {

    private final ParserService parserService = new ParserService();

    /**
     * <p>정상 YAML → DTO 변환이 성공해야 한다.</p>
     *
     * @throws IOException YAML 파일을 읽지 못할 때 발생
     */
    @Test
    public void createDTO_parsesYamlIntoSpecDTO() throws IOException {
        // given
        String path = "src/main/resources/test/ParserServiceTest01.yaml";

        // when
        SpecDTO dto = parserService.createDTO(path);

        // then
        assertNotNull("DTO should not be null", dto);
        assertEquals("Second variable name must be 'K'",
                "K", dto.getVariables().get(1).getName());
        assertEquals("Variable 'V' expected in first pattern body",
                "V", dto.getPatterns()
                        .get(0).getBody().getVariables().get(1).getName());
    }
}
