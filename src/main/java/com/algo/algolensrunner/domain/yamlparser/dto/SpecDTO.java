package com.algo.algolensrunner.domain.yamlparser.dto;

import com.algo.algolensrunner.domain.yamlparser.dto.arrays.ArraysDTO;
import com.algo.algolensrunner.domain.yamlparser.dto.patterns.PatternDTO;
import com.algo.algolensrunner.domain.yamlparser.dto.variables.VariablesDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SpecDTO {

    List<VariablesDTO> variables;
    List<ArraysDTO> arrays;
    List<PatternDTO> patterns;
    List<String> print;
}
