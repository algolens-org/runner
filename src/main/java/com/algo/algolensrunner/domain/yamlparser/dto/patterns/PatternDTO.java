package com.algo.algolensrunner.domain.yamlparser.dto.patterns;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/** 패턴 자체(반복·제약 포함) */
@Getter @Setter
public class PatternDTO {

    String name;
    /** 반복 횟수(정수·변수·식 가능) */
    String repeat;
    RepeatConstraintsDTO repeatConstraints;
    PatternBodyDTO body;
    List<String> print;
}