package com.kpi.springcourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Opportunity {
    private Long id;
    private String content;
}
