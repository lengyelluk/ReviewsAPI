package com.example.demo.model.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @Range(min=1, max=5)
    @Column(nullable = false)
    @JsonProperty
    private Integer rating;

    @Column(nullable = false)
    @JsonProperty
    private String text;

    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    @JsonProperty
    private LocalDateTime created_time;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //one review is mapped to many comments
    @OneToMany(mappedBy = "review")
    private List<Comment> commentList = new ArrayList<>();

    public Review() {}

    public Review(Long id, @Range(min = 1, max = 5) Integer rating, String text, LocalDateTime created_time, Product product, User user) {
        this.id = id;
        this.rating = rating;
        this.text = text;
        this.created_time = created_time;
        this.product = product;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
