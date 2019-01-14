package com.enums;

public enum AccidentsLevel {
    LOW("0,5 accidents per year"),
    MEDIUM("1 accidents per year"),
    HIGH("1,5 accidents per year"),
    VERYHIGH("2 accidents per year");

    private final String level;

    AccidentsLevel(String level) {
        this.level = level;
    }
}
