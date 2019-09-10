# Reviews API
REST API that supports the customer reviews section of a product page in an e-commerce application.

Polyglot persistence was used and Review information is stored in both MySQL and MongoDB in different shapes. API supports all operations that a modern e-commerce application’s product page requires. Three entities are persisted:
- product
- review
- comment

Each product can have many reviews added by the customers. Each review can have many comments.

The project shows:
- connection between an application and database
- use of Flyway with SQL scripts to create entity tables
- Spring Data JPA repositories and data modeling
- Spring Data Mongo repositories
- tests of both type of repositories

### Instructions
1. clone the repository
2. start mysql and mongodb
3. api can be used using tools like Postman

Create a new Product (POST request)
```api
http://localhost:8080/products/
```

Body:
```json
{
	"name": "product",
	"description": "desc",
	"price": 10.50
}
```

Get a product by id (GET request)
```api
http://localhost:8080/products/{id}
```

Get a product by name (GET request)
```api
http://localhost:8080/products/name/{name}
```

Get all existing products (GET request)
```api
http://localhost:8080/products/
```

Get a review for a product by product id (GET request)
```api
http://localhost:8080/reviews/products/{product_id}
```

Add a new review for a product (POST request)
```api
http://localhost:8080/reviews/products/{product_id}
```
Body:
```json
{
	"rating": 5,
	"review_title": "Title",
	"review_text": "Long text"
}
```

Get comments for a review (GET request)
```api
http://localhost:8080/comments/reviews/{review_id}
```

Add a new comment for a review (POST request)
```api
http://localhost:8080/comments/reviews/{review_id}
```
Body:
```json
{
	"comment_text": "the best comment ever"
}
```

### To do (still in progress)
1. The project uses its own JSON representation for REST instead of serializing the entities directly.
2. The project uses aggregations to calculate average rating for the product.
