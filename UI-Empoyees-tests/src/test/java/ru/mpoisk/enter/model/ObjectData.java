package ru.mpoisk.enter.model;

public class ObjectData {
    private final String name;
    private final String comment;

    public ObjectData(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }
}
