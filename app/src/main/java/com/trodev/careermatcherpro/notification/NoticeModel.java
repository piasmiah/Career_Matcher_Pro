package com.trodev.careermatcherpro.notification;

public class NoticeModel {

    String title, job, image;

    public NoticeModel() {
    }

    public NoticeModel(String title, String job, String image) {
        this.title = title;
        this.job = job;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
