package com.adaptionsoft.games;

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
    private static final Map<String, CategoryType> RELATIONS = new HashMap<>();

    static {
        for (CategoryType relationType : values()) {
            RELATIONS.put(relationType.getCategory(), relationType);
        }
    }

    CategoryType(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
