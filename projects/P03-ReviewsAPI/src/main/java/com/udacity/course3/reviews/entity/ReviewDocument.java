package com.udacity.course3.reviews.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("reviews")
public class ReviewDocument {

    @Id
    private String id;
    private Integer rating;
    private String review_title;
    private String review_text;
    private List<CommentDocument> commentDocuments;
    private Product product;

    public ReviewDocument() {}

    public ReviewDocument(Integer rating, String review_title, String review_text) {
        this.rating = rating;
        this.review_title = review_title;
        this.review_text = review_text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview_title() {
        return review_title;
    }

    public void setReview_title(String review_title) {
        this.review_title = review_title;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public List<CommentDocument> getCommentDocuments() {
        return commentDocuments;
    }

    public void setCommentDocuments(List<CommentDocument> commentDocuments) {
        this.commentDocuments = commentDocuments;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
