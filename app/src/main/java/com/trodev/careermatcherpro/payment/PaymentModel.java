package com.trodev.careermatcherpro.payment;

public class PaymentModel {

    String name, email, phone, payment_method, transaction, packages, status;

    public PaymentModel() {
    }

    public PaymentModel(String name, String email, String phone, String payment_method, String transaction, String packages, String status) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.payment_method = payment_method;
        this.transaction = transaction;
        this.packages = packages;
        this.status = status;
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

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
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
}
