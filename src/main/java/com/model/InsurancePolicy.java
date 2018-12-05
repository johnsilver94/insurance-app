package com.model;

import java.util.Date;
import java.util.List;

import com.enums.InsuranceType;

public abstract class InsurancePolicy {
    private Integer id;
    private InsuranceType type;
    private Date starDate;
    private Date endDate;
    private InsurancePlan plan;
}
