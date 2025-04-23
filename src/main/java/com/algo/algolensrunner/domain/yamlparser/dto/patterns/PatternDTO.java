package com.algo.algolensrunner.domain.yamlparser.dto.patterns;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PatternDTO {

    String name;
    String repeat;
    RepeatConstraintsDTO repeatConstraints;
    PatternBodyDTO body;
    List<String> print;
}
