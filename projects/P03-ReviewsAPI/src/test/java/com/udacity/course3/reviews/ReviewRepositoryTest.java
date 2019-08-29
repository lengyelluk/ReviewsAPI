package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Before;
import org.junit.BeforeClass;
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
public class ReviewRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProductRepository productRepository;


    @Test
    public void givenProduct_whenReviewIsSavedForProduct_thenReviewIsReturnedUnderProduct(){
        Product product = new Product();
        product.setName("product");
        productRepository.save(product);

        Review review = new Review();
        review.setReview_title("Title");
        review.setReview_text("Text");
        review.setProduct(product);
        reviewRepository.save(review);

        List<Review> reviewList = reviewRepository.findAllByProduct(product);

        assertThat(reviewList).isNotNull();
        assertEquals(Integer.valueOf(1), reviewList.get(0).getId());
        assertEquals("Title", reviewList.get(0).getReview_title());
        assertEquals("Text", reviewList.get(0).getReview_text());

    }


}
