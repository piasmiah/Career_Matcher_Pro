package com.trodev.careermatcherpro;

public class PremiumModel {

    String  name, topic;

    public PremiumModel() {
    }

    public PremiumModel(String name, String topic) {
        this.name = name;
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
