-- Insert categories
INSERT INTO category (id, description, name)
VALUES (NEXTVAL('category_seq'), 'Gadgets and devices', 'Electronics');

INSERT INTO category (id, description, name)
VALUES (NEXTVAL('category_seq'), 'Apparel and accessories', 'Clothing');

-- Insert products
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES (NEXTVAL('product_seq'), 'High-end laptop', 'Laptop', 10, 999.99, (SELECT id FROM category WHERE name = 'Electronics'));

INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES (NEXTVAL('product_seq'), 'Cotton T-shirt', 'Shirt', 50, 19.99, (SELECT id FROM category WHERE name = 'Clothing'));