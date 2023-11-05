package com.trodev.careermatcherpro.payment;

public class PackageModel {

    private String aID, name, email, phone, payments, transactions, packages, status, date, time, uid;

    public PackageModel() {
    }

    public PackageModel(String aID, String name, String email, String phone, String payments, String transactions, String packages, String status, String date, String time, String uid) {
        this.aID = aID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.payments = payments;
        this.transactions = transactions;
        this.packages = packages;
        this.status = status;
        this.date = date;
        this.time = time;
        this.uid = uid;
    }

    public String getaID() {
        return aID;
    }

    public void setaID(String aID) {
        this.aID = aID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public String getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions = transactions;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getuID() {
        return uid;
    }

    public void setuID(String uID) {
        this.uid = uID;
    }
}
