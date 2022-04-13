package com.dscfgos.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeCategory implements Category {

    private final String categoryName;
    private List<Category> categories;

    public CompositeCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addCategory(Category category) {
        if (categories == null) {
            categories = new ArrayList<>();
        }
        categories.add(category);
    }

    public void removeCategory(Category category) {
        if (categories != null) {
            categories.remove(category);
        }
    }

    @Override
    public void showDetails() {
        System.out.println("Composite:" + categoryName);
        if (categories != null) {
            System.out.println("Childs:");
            categories.forEach(category -> {
                System.out.print("-");
                category.showDetails();
            });
        }
    }
}
