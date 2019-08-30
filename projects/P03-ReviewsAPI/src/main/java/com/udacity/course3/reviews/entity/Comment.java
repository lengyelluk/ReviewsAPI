package com.udacity.course3.reviews.entity;

public class Comment {

    private String comment_text;

    public Comment() {}

    public Comment(String comment_text) {
        this.comment_text = comment_text;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }
}
