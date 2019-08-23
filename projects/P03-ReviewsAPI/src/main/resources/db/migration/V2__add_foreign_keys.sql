/*
each review is related to one specific product
*/
ALTER TABLE review ADD CONSTRAINT review_product_fk FOREIGN KEY (product_id) REFERENCES product (id);
/*
each comment is related to one specific review
*/
ALTER TABLE comment ADD CONSTRAINT comment_review_fk FOREIGN KEY (review_id) REFERENCES review (id);