package com.kpi.springcourse.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kpi.springcourse.model.Opportunity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OpportunityDto {
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date deadline;
    private Boolean asap;
    private String content;

    public Opportunity toOpportunity() {
        return new Opportunity(null, name, deadline, asap, content, null);
    }
}
