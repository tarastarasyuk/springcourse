package com.kpi.springcourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Opportunity {
    private Long id;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    private Boolean ASAP;
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
}
