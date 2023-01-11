package org.example.model;

public class Band {
    private String name;
    private Style style;

    public Band(String name, Style style) {
        this.name = name;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public Style getStyle() {
        return style;
    }
}
