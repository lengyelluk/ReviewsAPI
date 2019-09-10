# Reviews API
REST API that supports the customer reviews section of a product page in an e-commerce application.

Polyglot persistence was used and Review information is stored in both MySQL and MongoDB in different shapes. API supports all operations that a modern e-commerce application’s product page requires.

The project shows:
- connection between an application and database
- use of Flyway with SQL scripts to create entity tables
- Spring Data JPA repositories and data modeling
- Spring Data Mongo repositories
- tests of both type of repositories


### To do (still in progress)
1. The project uses its own JSON representation for REST instead of serializing the entities directly.
2. The project uses aggregations to calculate average rating for the product.
