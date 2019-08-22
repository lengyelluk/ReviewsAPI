package com.example.demo;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.*;

@EnableJpaRepositories("com.example.demo.model.persistence.repositories")
@EntityScan("com.example.demo.model.persistence")
@SpringBootApplication
public class SareetaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SareetaApplication.class, args);
		//Flyway instance
		Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/udacity",
				"udacityuser", "beatles").load();
		//start migration
		flyway.migrate();
	}



		/*
			final String db_url = "jdbc:mysql://localhost:3306";
			final String user = "udacityuser";
			final String password = "beatles";

			final String DELETE_DATABASE = "DROP DATABASE IF EXISTS udacity";
			final String CREATE_DATABASE = "CREATE DATABASE udacity";
			final String USE_DATABASE = "use udacity";

			final String CREATE_TABLE_COMMENT = "CREATE TABLE comment ("
					+ "id INT AUTO_INCREMENT NOT NULL,"
					+ "text VARCHAR(500) NOT NULL,"
					+ "created_time TIMESTAMP NOT NULL,"
					+ "PRIMARY KEY (id))";

			//ALTER TABLE katalog ADD FOREIGN KEY (`Sprache`) REFERENCES Sprache(`ID`);

			final String CREATE_TABLE_PRODUCT = "CREATE TABLE product ("
					+ "id INT NOT NULL,"
					+ "name VARCHAR(150) NOT NULL,"
					+ "price DECIMAL(6,2) NOT NULL,"
					+ "PRIMARY KEY (id))";

			final String CREATE_TABLE_REVIEW= "CREATE TABLE review ("
					+ "id INT AUTO_INCREMENT NOT NULL,"
					+ "product_id INT NOT NULL,"
					+ "comment_id INT NOT NULL,"
					+ "PRIMARY KEY (id),"
					+ "FOREIGN KEY (product_id) REFERENCES product (id),"
					+ "FOREIGN KEY (comment_id) REFERENCES comment (id))";

			try {
				//get connection to mysql databse
				try(Connection con = DriverManager.getConnection(db_url, user, password)) {
					System.out.println("Connected to " + con.getMetaData().getDatabaseProductName());

					try(Statement stmt = con.createStatement()) {
						stmt.execute(DELETE_DATABASE);
						System.out.println("delete database");
					}

					try(Statement stmt = con.createStatement()) {
						stmt.execute(CREATE_DATABASE);
						System.out.println("create database");
					}

					try(Statement stmt = con.createStatement()) {
						stmt.execute(USE_DATABASE);
						System.out.println("use database");
					}

					//create tables
					try(Statement stmt = con.createStatement()) {
						stmt.executeUpdate(CREATE_TABLE_COMMENT);
					}
					try(Statement stmt = con.createStatement()) {
						stmt.executeUpdate(CREATE_TABLE_PRODUCT);
					}
					try(Statement stmt = con.createStatement()) {
						stmt.executeUpdate(CREATE_TABLE_REVIEW);
					}
				}
			} catch (SQLException e) {
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
				System.out.println(e.getSQLState());
			}
		};
	}*/

}
