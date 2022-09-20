package com.kpi.springcourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Opportunity {
    private Long id;
    private Date deadline;
    private Boolean ASAP;
    private String content;
}
