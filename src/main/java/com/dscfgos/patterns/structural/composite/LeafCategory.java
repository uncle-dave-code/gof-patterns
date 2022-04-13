package com.dscfgos.patterns.structural.composite;

public class LeafCategory implements Category {

    private final String categoryName;

    public LeafCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public void showDetails() {
        System.out.println("Leaf:" + categoryName);
    }
}
