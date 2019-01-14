package com.enums;

public enum ExperienceLevel {
    NEWBIE("<5 years of experience"),
    INTERMEDIATE("between 5 and 15 years of experience"),
    EXPERT(">15 years of experience");

    private final String level;

    ExperienceLevel(String level) {
        this.level = level;
    }
}
