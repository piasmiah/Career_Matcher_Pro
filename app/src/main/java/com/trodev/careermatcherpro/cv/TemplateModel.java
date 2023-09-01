package com.trodev.careermatcherpro.cv;

public class TemplateModel {

    String name, link;

    public TemplateModel() {
    }

    public TemplateModel(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
