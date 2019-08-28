package com.udacity.course3.reviews;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void givenAproduct_whenProductSaved_thenProductAvailableInRepository() {
        Product product = new Product();
        product.setName("product");
        product.setDescription("product description");
        product.setPrice(new BigDecimal(100));
        productRepository.save(product);

        Optional<Product> productOptional = productRepository.findById(1);
        if(productOptional.isPresent()) {
            Product productTest = productOptional.get();
            assertEquals(productTest.getName(), "product");
            assertEquals(productTest.getDescription(), "product description");
            assertEquals(productTest.getPrice(), new BigDecimal(100));
        } else {
            assertTrue(false);
        }
    }

}
