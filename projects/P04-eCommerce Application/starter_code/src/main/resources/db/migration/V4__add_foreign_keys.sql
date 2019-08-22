/*
Each comment belongs to a review
*/
ALTER TABLE comment ADD CONSTRAINT fk_review_id FOREIGN KEY (review_id) REFERENCES review (id);
/*
Each review belongs to a product
*/
ALTER TABLE review ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES product (id);
