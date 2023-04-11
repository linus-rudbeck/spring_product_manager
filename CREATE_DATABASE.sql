CREATE DATABASE product_manager;

USE product_manager;

CREATE TABLE categories (
                            category_id INT AUTO_INCREMENT NOT NULL,
                            category_name VARCHAR(255) NOT NULL,
                            description VARCHAR(255),
                            PRIMARY KEY (category_id)
);

INSERT INTO categories (category_name, description) VALUES
                                                        ('Schampoo', 'Something for your hair'),
                                                        ('Candy', 'Something sweet');

SELECT * FROM categories;