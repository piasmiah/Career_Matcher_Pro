package com.trodev.careermatcherpro.advice;

public class AdviceModel {

    String advice, writer, date ;

    public AdviceModel() {
    }

    public AdviceModel(String advice, String writer, String date) {
        this.advice = advice;
        this.writer = writer;
        this.date = date;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
