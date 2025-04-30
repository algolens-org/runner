package com.algo.algolensrunner.domain.yamlparser.dto.patterns;

import com.algo.algolensrunner.domain.yamlparser.dto.arrays.ArraysDTO;
import com.algo.algolensrunner.domain.yamlparser.dto.variables.VariablesDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PatternBodyDTO {

    List<VariablesDTO> variables;
    List<ArraysDTO> arrays;
    List<PatternDTO> patterns;
}
