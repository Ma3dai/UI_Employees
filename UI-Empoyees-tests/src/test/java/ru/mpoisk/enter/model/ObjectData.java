package ru.mpoisk.enter.model;

public class ObjectData {
    private String name;
    private String comment;
    private String group;

    public ObjectData(String name, String comment, String group) {
        this.name = name;
        this.comment = comment;
         this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

   public String getGroup() {
      return group;
   }
}
