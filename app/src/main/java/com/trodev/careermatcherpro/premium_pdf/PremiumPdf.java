package com.trodev.careermatcherpro.premium_pdf;

import android.media.Image;

public class PremiumPdf {
    String pdfTitle, pdfUrl;

    public PremiumPdf() {
    }

    public PremiumPdf(String pdfTitle, String pdfUrl) {
        this.pdfTitle = pdfTitle;
        this.pdfUrl = pdfUrl;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
