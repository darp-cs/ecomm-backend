DROP TABLE ecomm.user_role;
DROP TABLE ecomm.product;
DROP TABLE ecomm.role;
DROP TABLE ecomm.user;


CREATE TABLE ecomm.user (
    id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    username VARCHAR(255) NOT NULL, 
    email VARCHAR(255) NOT NULL, 
    first_name VARCHAR(255) NOT NULL, 
    last_name VARCHAR(255) NOT NULL, 
    password VARCHAR(255) NOT NULL 
);

INSERT INTO ecomm.user (username, email, first_name, last_name, password)
VALUES
    ('asanchez', 'angela.sanchez@example.com', 'Angela', 'Sanchez', '$2a$10$NDHvJra9yYM9A69W.uCZp.2KFx4ol0Z7SWWdBjK7.8g1EAH9.Wqfy'),-- 4ng3l@#P@ss! 
    ('jrogers', 'jeffrey.rogers@example.com', 'Jeffrey', 'Rogers', '$2a$10$GBLtCMJbO2Guy8OXBr07MeZgGWD.bKblmURiHyf1Tn44yvFx.Ckr6'), -- J3ff#R0g3r$P@ss!
    ('swalker', 'shirley.walker@example.com', 'Shirley', 'Walker', '$2a$10$kuRo2lUEpPZAZT1F8p6Wr.tZbjhKJh/pY5vJcq6ZB16gLFu0PiGva'), -- 5h!rL3y#P@ss!
    ('gbrown', 'george.brown@example.com', 'George', 'Brown', '$2a$10$AEFJ2AS9VRm7yVqKMrVxbeCulMotRBKQ7uZas6U2ZLt03EM2QN.ly'), -- G30rg3#Br0wn$P@ss!
    ('kstewart', 'karen.stewart@example.com', 'Karen', 'Stewart', '$2a$10$YA1IYzZFkkLYkj4m/m.wguDOnql9Tpt5IHDRYzI.NeaP7QPYRICrK'), -- K@r3n#St3w@rt$P@ss!
    ('ajohnson', 'anthony.johnson@example.com', 'Anthony', 'Johnson', '$2a$10$5kRKCCo3ACN2jngzVSvTgeZKIhAonNTQRp0jvRSpuD9JYsNFUbUBO'), -- 4nth0ny#J0hn$on$P@ss!
    ('cwilliams', 'carolyn.williams@example.com', 'Carolyn', 'Williams', '$2a$10$weysyNXkpFHj2zQ28BL9z.910eiQH4X6i1ZbYC8y7ihjq2yWIL0mq'), -- C@r0lyn#W!ll!@m$P@ss!
    ('diego1', 'diego1@example.com', 'diego', 'rodriguez', '$2a$10$KE53ERrAD6sgeGZUMWXw9OIUCM5oa6vA692a9P3d26nJ/UWrG3F8W'); -- password


CREATE TABLE ecomm.product (
    id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    price DECIMAL(10, 2) NOT NULL,
    description VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    category VARCHAR(255) NOT NULL DEFAULT 'None',
    image BLOB
);


-- Inserting 55 records without image data
INSERT INTO ecomm.product (price, description, name, category)
VALUES
    (39.99, 'Stylish stainless steel water bottle', 'Water Bottle', 'Kitchenware'),
    (19.95, 'High-performance wireless mouse', 'Wireless Mouse', 'Electronics'),
    (149.99, 'Designer leather handbag', 'Leather Handbag', 'Accessories'),
    (9.99, 'Set of 6 ceramic dinner plates', 'Dinner Plates (Set of 6)', 'Kitchenware'),
    (299.99, 'Ultra HD 4K Smart TV', '4K Smart TV', 'Electronics'),
    (79.95, 'Premium noise-canceling headphones', 'Noise-Canceling Headphones', 'Electronics'),
    (59.99, 'Fancy stainless steel flatware set', 'Flatware Set', 'Kitchenware'),
    (249.99, 'High-end gaming desktop computer', 'Gaming Desktop', 'Computers'),
    (24.95, 'Portable power bank with fast charging', 'Power Bank', 'Electronics'),
    (8.99, 'Set of 4 glass coffee mugs', 'Coffee Mugs (Set of 4)', 'Kitchenware'),
    (159.99, 'Elegant men''s dress shoes', 'Men''s Dress Shoes', 'Footwear'),
    (69.95, 'Wireless charging pad for smartphones', 'Wireless Charging Pad', 'Electronics'),
    (49.99, 'Stylish women''s sunglasses', 'Sunglasses', 'Accessories'),
    (12.99, 'Set of 8 stainless steel steak knives', 'Steak Knives (Set of 8)', 'Kitchenware'),
    (349.99, 'Smart home security camera system', 'Security Camera System', 'Electronics'),
    (34.95, 'Premium leather phone case', 'Phone Case', 'Accessories'),
    (179.99, 'Professional-grade chef''s knife', 'Chef''s Knife', 'Kitchenware'),
    (54.99, 'Fitness tracker with heart rate monitor', 'Fitness Tracker', 'Electronics'),
    (29.95, 'Fashionable women''s scarf', 'Scarf', 'Accessories'),
    (14.99, 'Set of 6 porcelain soup bowls', 'Soup Bowls (Set of 6)', 'Kitchenware'),
    (449.99, 'High-performance graphics card', 'Graphics Card', 'Computers'),
    (129.95, 'Bluetooth wireless earphones', 'Wireless Earphones', 'Electronics'),
    (69.99, 'Designer men''s watch', 'Men''s Watch', 'Accessories'),
    (7.49, 'Set of 6 ceramic coffee mugs', 'Coffee Mugs (Set of 6)', 'Kitchenware'),
    (249.99, 'Powerful quad-core gaming laptop', 'Gaming Laptop', 'Computers'),
    (99.95, 'Wireless Bluetooth speaker system', 'Bluetooth Speaker System', 'Electronics'),
    (39.99, 'Premium leather notebook cover', 'Notebook Cover', 'Accessories'),
    (19.95, 'Wireless keyboard and mouse combo', 'Keyboard & Mouse Combo', 'Electronics'),
    (179.99, 'Professional DSLR camera', 'DSLR Camera', 'Electronics'),
    (6.99, 'Set of 4 glass dessert bowls', 'Dessert Bowls (Set of 4)', 'Kitchenware'),
    (499.99, 'High-resolution 27" computer monitor', 'Computer Monitor', 'Computers'),
    (149.95, 'Smart home voice assistant', 'Voice Assistant', 'Electronics'),
    (29.99, 'Stainless steel travel mug', 'Travel Mug', 'Kitchenware'),
    (14.95, 'Wireless Bluetooth earbuds', 'Bluetooth Earbuds', 'Electronics'),
    (99.99, 'Classic men''s wristwatch', 'Men''s Wristwatch', 'Accessories'),
    (6.99, 'Set of 6 stainless steel teaspoons', 'Teaspoons (Set of 6)', 'Kitchenware'),
    (179.99, 'Compact digital camera', 'Digital Camera', 'Electronics'),
    (79.95, 'Noise-canceling headphones', 'Noise-Canceling Headphones', 'Electronics'),
    (59.99, 'Stainless steel flatware set', 'Flatware Set', 'Kitchenware'),
    (249.99, 'High-performance desktop computer', 'Desktop Computer', 'Computers'),
    (24.95, 'Portable power bank', 'Power Bank', 'Electronics'),
    (8.99, 'Set of 4 glass coffee mugs', 'Coffee Mugs (Set of 4)', 'Kitchenware'),
    (159.99, 'Elegant women''s dress shoes', 'Women''s Dress Shoes', 'Footwear'),
    (69.95, 'Wireless charging pad', 'Wireless Charging Pad', 'Electronics'),
    (49.99, 'Designer men''s belt', 'Men''s Belt', 'Accessories'),
    (12.99, 'Set of 8 stainless steel soup spoons', 'Soup Spoons (Set of 8)', 'Kitchenware'),
    (349.99, 'Smart home security system', 'Security System', 'Electronics'),
    (34.95, 'Premium leather wallet', 'Leather Wallet', 'Accessories'),
    (179.99, 'Professional chef''s knife', 'Chef''s Knife', 'Kitchenware'),
    (54.99, 'Fitness tracker with GPS', 'GPS Fitness Tracker', 'Electronics'),
    (29.95, 'Fashionable men''s tie', 'Men''s Tie', 'Accessories'),
    (14.99, 'Set of 6 porcelain dessert plates', 'Dessert Plates (Set of 6)', 'Kitchenware'),
    (29.99, 'High-quality leather wallet', 'Leather Wallet 2', 'Accessories'),
    (14.95, 'Wireless Bluetooth earbuds', 'Bluetooth Earbuds', 'Electronics'),
    (99.99, 'Classic men''s wristwatch with leather strap', 'Men''s Wristwatch', 'Accessories'),
    (6.99, 'Set of 6 stainless steel teaspoons', 'Teaspoons (Set of 6)', 'Kitchenware'),
    (179.99, 'Compact digital camera with 20MP sensor', 'Digital Camera', 'Electronics');

CREATE TABLE ecomm.role(
id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
name VARCHAR(255) NOT NULL,
description VARCHAR(255) NOT NULL
);

INSERT INTO ecomm.role(name,description) VALUES('General User', 'general user with minimal permissions');

CREATE TABLE ecomm.user_role (
user_id  INT NOT NULL,
role_id INT NOT NULL,
constraint role_id_fk foreign key (role_id) references role(id),
constraint user_id_fk foreign key (user_id) references user(id),
primary key(user_id,role_id)
);

INSERT INTO ecomm.user_role(user_id,role_id) VALUES(8,1);

commit;
    
select * from ecomm.user;
select * from ecomm.product;
select * from ecomm.role;
select * from ecomm.user_role;