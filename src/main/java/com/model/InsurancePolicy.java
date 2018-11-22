package com.model;

import java.util.Date;
import java.util.List;

public abstract class InsurancePolicy {
    private Integer id;
    private Enum type;
    private Date starDate;
    private Date endDate;
    private InsurancePlan plan;
}
