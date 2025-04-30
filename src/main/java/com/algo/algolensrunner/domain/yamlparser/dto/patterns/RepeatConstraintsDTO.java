package com.algo.algolensrunner.domain.yamlparser.dto.patterns;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RepeatConstraintsDTO {
    String structure;
    String elementName;
    String min;
    String max;
}
