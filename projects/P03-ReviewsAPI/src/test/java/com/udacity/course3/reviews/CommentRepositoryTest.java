package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProductRepository productRepository;


    @Test
    public void givenProductWithReview_whenCommentIsSavedForReview_thenCommentIsReturnedUnderReview(){
        Product product = new Product();
        productRepository.save(product);

        Review review = new Review();
        review.setProduct(product);
        reviewRepository.save(review);

        Comment comment = new Comment();
        comment.setReview(review);
        comment.setComment_text("comment text");
        commentRepository.save(comment);

        List<Comment> commentList = commentRepository.findAllByReview(review);

        assertThat(commentList).isNotNull();
        assertEquals(Integer.valueOf(1), commentList.get(0).getId());
        assertEquals("comment text", commentList.get(0).getComment_text());
    }
}
