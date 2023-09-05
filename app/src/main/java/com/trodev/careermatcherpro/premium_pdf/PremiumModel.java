package com.trodev.careermatcherpro.premium_pdf;

public class PremiumModel {

    String pdfTitle, pdfLink;

    public PremiumModel() {
    }

    public PremiumModel(String pdfTitle, String pdfLink) {
        this.pdfTitle = pdfTitle;
        this.pdfLink = pdfLink;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }
}
