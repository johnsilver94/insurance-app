package com.enums;

public enum CoverageLevel {
	GOLD("higher premiums, lower costs for care"),
	SILVER("lower premiums, higher cost for care"),
	BRONZE("lowest premiums, highest costs for care");
	
	private final String level;
	
	CoverageLevel(String level) {
        this.level = level;
    }
}
