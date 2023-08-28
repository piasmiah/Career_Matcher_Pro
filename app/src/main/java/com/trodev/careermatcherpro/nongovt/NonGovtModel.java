package com.trodev.careermatcherpro.nongovt;

public class NonGovtModel {

    private String postname, postdetails, startdate, enddate, source,  link , image, pdfUrl;

    public NonGovtModel() {
    }

    public NonGovtModel(String postname, String postdetails, String startdate, String enddate, String source, String link, String image, String pdfUrl) {
        this.postname = postname;
        this.postdetails = postdetails;
        this.startdate = startdate;
        this.enddate = enddate;
        this.source = source;
        this.link = link;
        this.image = image;
        this.pdfUrl = pdfUrl;
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }

    public String getPostdetails() {
        return postdetails;
    }

    public void setPostdetails(String postdetails) {
        this.postdetails = postdetails;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
