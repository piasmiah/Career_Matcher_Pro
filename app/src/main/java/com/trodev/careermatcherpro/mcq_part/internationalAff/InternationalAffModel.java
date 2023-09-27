package com.trodev.careermatcherpro.mcq_part.internationalAff;

public class InternationalAffModel {

    String mcq_no, grp_ques, first, second, third, fourth, ans;
    private boolean expandable;

    public InternationalAffModel() {
    }

    public InternationalAffModel(String mcq_no, String grp_ques, String first, String second, String third, String fourth, String ans) {
        this.mcq_no = mcq_no;
        this.grp_ques = grp_ques;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.ans = ans;
        this.expandable = false;
    }

    public String getMcq_no() {
        return mcq_no;
    }

    public void setMcq_no(String mcq_no) {
        this.mcq_no = mcq_no;
    }

    public String getGrp_ques() {
        return grp_ques;
    }

    public void setGrp_ques(String grp_ques) {
        this.grp_ques = grp_ques;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }
}
