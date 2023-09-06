package com.trodev.careermatcherpro.cv;

public class UserModel {

    String payment_method, transaction_id ;
    String name, parents, address, gmail, mobile, skills, educations, nationality,
    gender, religion_married_blood, languages, extra_curriculmn, training_certificate,
    experience, social_media;
    String statustv, template;
    String image;

    public UserModel() {
    }

    public UserModel(String payment_method, String transaction_id, String name, String parents, String address, String gmail, String mobile, String skills, String educations, String nationality, String gender, String religion_married_blood, String languages, String extra_curriculmn, String training_certificate, String experience, String social_media, String statustv, String template, String image) {
        this.payment_method = payment_method;
        this.transaction_id = transaction_id;
        this.name = name;
        this.parents = parents;
        this.address = address;
        this.gmail = gmail;
        this.mobile = mobile;
        this.skills = skills;
        this.educations = educations;
        this.nationality = nationality;
        this.gender = gender;
        this.religion_married_blood = religion_married_blood;
        this.languages = languages;
        this.extra_curriculmn = extra_curriculmn;
        this.training_certificate = training_certificate;
        this.experience = experience;
        this.social_media = social_media;
        this.statustv = statustv;
        this.template = template;
        this.image = image;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEducations() {
        return educations;
    }

    public void setEducations(String educations) {
        this.educations = educations;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion_married_blood() {
        return religion_married_blood;
    }

    public void setReligion_married_blood(String religion_married_blood) {
        this.religion_married_blood = religion_married_blood;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getExtra_curriculmn() {
        return extra_curriculmn;
    }

    public void setExtra_curriculmn(String extra_curriculmn) {
        this.extra_curriculmn = extra_curriculmn;
    }

    public String getTraining_certificate() {
        return training_certificate;
    }

    public void setTraining_certificate(String training_certificate) {
        this.training_certificate = training_certificate;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSocial_media() {
        return social_media;
    }

    public void setSocial_media(String social_media) {
        this.social_media = social_media;
    }

    public String getStatustv() {
        return statustv;
    }

    public void setStatustv(String statustv) {
        this.statustv = statustv;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
