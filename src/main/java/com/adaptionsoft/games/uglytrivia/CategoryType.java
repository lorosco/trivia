package com.adaptionsoft.games.uglytrivia;

import java.util.HashMap;
import java.util.Map;

public enum CategoryType {

    ROCK("Rock"),
    POP("Pop"),
    TECHNO("Techno"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    PHILOSOPHY("Philosophy"),
    LITTERATURE("Litterature"),
    GEAOGRAPHY("Geography"),
    PEOPLE("People");

    String category;
    private static final Map<String, CategoryType> CATEGORIES = new HashMap<>();

    static {
        for (CategoryType categoryType : values()) {
            CATEGORIES.put(categoryType.getCategory(), categoryType);
        }
    }

    CategoryType(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
