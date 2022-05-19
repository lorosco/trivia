package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private CategoryType categoryType;
    private List<String> questions = new ArrayList<>();

    public Category(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public void addQuestion(String question){
        this.questions.add(question);
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }
}
