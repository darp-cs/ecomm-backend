DROP TABLE ecomm.product;
DROP TABLE ecomm.role;
DROP TABLE ecomm.user;
DROP TABLE ecomm.user_role;

CREATE TABLE ecomm.user (
    id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    user_name VARCHAR(255) NOT NULL, 
    email VARCHAR(255) NOT NULL, 
    first_name VARCHAR(255) NOT NULL, 
    last_name VARCHAR(255) NOT NULL, 
    password VARCHAR(255) NOT NULL 
);

INSERT INTO ecomm.user (user_name, email, first_name, last_name, password)
VALUES
    ('lsmith', 'lindasmith@example.com', 'Linda', 'Smith', 'P@ssw0rd!123'),
    ('bwilliams', 'brian.williams@example.com', 'Brian', 'Williams', 'W!ll!am$P@ss'),
    ('kjohnson', 'karen.johnson@example.com', 'Karen', 'Johnson', 'J0hn$onP@ss!'),
    ('rlee', 'richard.lee@example.com', 'Richard', 'Lee', 'L33R1ch#P@ss'),
    ('mmartinez', 'maria.martinez@example.com', 'Maria', 'Martinez', 'M@rt!n3zP@ss!'),
    ('jrodriguez', 'jose.rodriguez@example.com', 'Jose', 'Rodriguez', 'R0dr!gu3zP@ss!'),
    ('esmith', 'elizabeth.smith@example.com', 'Elizabeth', 'Smith', '3l!z@b3thP@ss!'),
    ('mjones', 'mark.jones@example.com', 'Mark', 'Jones', 'M@rk#J0n3$P@ss!'),
    ('jwilliams', 'julie.williams@example.com', 'Julie', 'Williams', 'J3w!ll1@m$P@ss!'),
    ('rthomas', 'rebecca.thomas@example.com', 'Rebecca', 'Thomas', 'R3b3cC@T#P@ss!'),
    ('wscott', 'william.scott@example.com', 'William', 'Scott', 'W!ll1@m$P@ss!'),
    ('pwhite', 'patricia.white@example.com', 'Patricia', 'White', 'P@tr!c1@#P@ss!'),
    ('mhill', 'michael.hill@example.com', 'Michael', 'Hill', 'M!k3@#H!ll$P@ss!'),
    ('asanchez', 'angela.sanchez@example.com', 'Angela', 'Sanchez', '4ng3l@#P@ss!'),
    ('jrogers', 'jeffrey.rogers@example.com', 'Jeffrey', 'Rogers', 'J3ff#R0g3r$P@ss!'),
    ('swalker', 'shirley.walker@example.com', 'Shirley', 'Walker', '5h!rL3y#P@ss!'),
    ('gbrown', 'george.brown@example.com', 'George', 'Brown', 'G30rg3#Br0wn$P@ss!'),
    ('kstewart', 'karen.stewart@example.com', 'Karen', 'Stewart', 'K@r3n#St3w@rt$P@ss!'),
    ('ajohnson', 'anthony.johnson@example.com', 'Anthony', 'Johnson', '4nth0ny#J0hn$on$P@ss!'),
    ('cwilliams', 'carolyn.williams@example.com', 'Carolyn', 'Williams', 'C@r0lyn#W!ll!@m$P@ss!');


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


CREATE TABLE ecomm.user_role (
id INT PRIMARY KEY NOT NULL UNIQUE,
name VARCHAR(255) NOT NULL,
user_id  INT NOT NULL,
role_id INT NOT NULL,
constraint role_id_fk foreign key (role_id) references role(id),
constraint user_id_fk foreign key (user_id) references user(id)
);

commit;
    
select * from ecomm.user;
select * from ecomm.product;
select * from ecomm.role;
select * from ecomm.user_role;