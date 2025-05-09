package com.fastcampus.Res9ueTeam.entity;

public enum Category {
    FOOD(CategoryType.EXPENSE),
    TRANSPORT(CategoryType.EXPENSE),
    ENTERTAINMENT(CategoryType.EXPENSE),
    SALARY(CategoryType.INCOME),
    BONUS(CategoryType.INCOME),
    SIDE_JOB(CategoryType.INCOME);

    private final CategoryType categoryType;

    Category(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }
}