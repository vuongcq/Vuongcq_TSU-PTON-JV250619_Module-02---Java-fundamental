DROP database ecommerce;
CREATE DATABASE Ecommerce;
USE  Ecommerce;

CREATE TABLE User (
user_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR (100) NOT NULL,
email VARCHAR (100) NOT NULL UNIQUE,
password VARCHAR (100) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
); 

CREATE TABLE Category (
category_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR (100) NOT NULL UNIQUE,
description VARCHAR (255)
);

CREATE TABLE Product (
product_id varchar(50) PRIMARY KEY,
name VARCHAR (100) NOT NULL UNIQUE,
price DECIMAL(10, 2) NOT NULL CHECK (Price > 0), 
stock INT  DEFAULT 0,
category_id INT,
 FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

CREATE TABLE Orders (
order_id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT,
FOREIGN KEY (user_id) REFERENCES User(user_id),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
total_amount INT
);

CREATE TABLE Order_Detail (
order_id INT,
FOREIGN KEY (order_id) REFERENCES Orders(order_id),
product_id VARCHAR(50),
FOREIGN KEY (product_id) REFERENCES Product(product_id),
PRIMARY KEY (order_id, product_id),
quantity INT NOT NULL CHECK (quantity>0),
price_at_time DECIMAL(10, 2) NOT NULL
);

-- Thêm dữ liệu cho bảng 
INSERT INTO category (name, description)
VALUES ("Điện tử", "Thiết bị công nghệ"),
("Thời trang", "Quần áo, phụ kiện"),
("Gia dụng", "Đồ dùng gia đình"),
("Thể thao", "	Thiết bị thể thao"),
("Sách", "Sách học, kỹ năng, kỹ thuật");

INSERT INTO user (name, email, password)
VALUES ('Nguyễn Văn An', 'annv@gmail.com', '123456'),
('Trần Thị Bình', 'binhtt@rikkeisoft.com', '123456'),
('Lê Văn Chiến', 'chienlv@rikkei.academy.com', '123456'),
('Nguyễn Hà Quyên', 'quyennh@rikkei.education.com', '123456'),
('Võ Văn Hải', 'haivv@rikkei.education.com', '123456');

INSERT INTO product (product_id, name, price, stock, category_id)
VALUES ('P001', 'Iphone 14', 20000000, 10,1),
('P002', 'Laptop Dell XPS', 30000000, 5,1),
('P003', 'Áo thun nam', 250000, 50,2),
('P004', 'Quần jeans nữ', 400000, 40,2),
('P005', 'Nồi cơm điện Sharp', 800000, 20,3);

INSERT INTO orders (user_id, total_amount, created_at)
VALUES( 1, 20200000 , '2024-06-01'),
(2, 325000, '2024-06-01'),
(3, 800000, '2024-06-02'),
(4,1500000, '2024-06-02'),
(5,700000, '2024-08-03'),
(1,150000, '2024-08-03'),
(2,3000000, '2024-08-03'),
(3,400000, '2024-08-03'),
(4,600000, '2024-09-20'),
(5,800000, '2024-09-20');

INSERT INTO order_detail (order_id, product_id, quantity, price_at_time)
VALUES (1,'P001',1,20000000),
(1,'P003',1,250000),
(2,'P004',1,400000),
(2,'P005',1,800000),
(3,'P003',2,250000),
(4,'P002',1,30000000),
(5,'P005',1,800000),
(6,'P001',1,20000000),
(7,'P002',1,30000000),
(8,'P004',1,400000),
(9,'P003',2,250000),
(10,'P005',1,800000);

-- Cập nhật dữ liệu
-- Cập nhật số lượng tồn kho của sản phẩm có product_id = ‘P002’ thành 3
UPDATE product
SET stock = 3
WHERE product_id = 'P002';

-- Cập nhật tên danh mục ‘Thời trang’ thành ‘Thời trang & Phụ kiện’
UPDATE category
SET name = 'Thời trang & Phụ kiện'
WHERE category_id =2;

--  Xóa danh mục có tên là ‘Sách’ 
DELETE 
FROM category
WHERE name = 'Sách';

-- EX2: Truy vấn dữ liệu
SELECT * FROM user;
SELECT * FROM product;
SELECT * FROM category;
SELECT p.product_id, p.name, p.stock
FROM product p;
SELECT o.order_id, o.user_id,o.total_amount
FROM orders o;
SELECT * FROM order_detail;

-- TRUY VẤN CÓ ĐIỀU KIỆN
-- Liệt kê người dùng có email kết thúc bằng “@gmail.com”.
SELECT u.email
FROM user u
WHERE u.email LIKE '%@gmail.com';

-- Liệt kê sản phẩm có giá trên 1 triệu đồng.
SELECT (name, price)  FROM product
WHERE product.price > 1000000;

-- Liệt kê đơn hàng có tổng tiền lớn hơn 5 triệu.
SELECT * FROM orders 
WHERE total_amount > 5000000;

-- Liệt kê sản phẩm còn hàng (stock > 0).
SELECT * FROM product
WHERE stock >0;

-- Liệt kê đơn hàng được tạo sau ngày 2024-06-05.
SELECT * FROM orders
WHERE created_at > '2024-06-05';

-- Liệt kê danh mục có tên là “Sách”.
SELECT * FROM category
WHERE name = 'Sách';

-- TRUY VẤN CÓ NHÓM DỮ LIỆU
-- Đếm số lượng sản phẩm thuộc mỗi danh mục.
SELECT 
    c.name,
    COUNT(p.product_id) AS product_count
FROM category c
LEFT JOIN product p
    ON c.category_id = p.category_id
GROUP BY c.category_id, c.name;

-- Liệt kê tên và giá của tất cả sản phẩm.
SELECT name, price
FROM product;

-- Liệt kê tên danh mục và mô tả.
SELECT c.name AS categoru_name,
p.name AS product_name, 
c.description
FROM  category c
LEFT JOIN  product p
ON c.category_id = p.category_id;

SELECT 
    c.name AS category_name, 
    p.name AS product_name, 
    c.description AS category_description
FROM category c
LEFT JOIN product p
    ON c.category_id = p.category_id;

-- Tính tổng số lượng tồn kho theo từng danh mục sản phẩm.
SELECT c.name AS category_name, 
SUM(p.stock) AS total_stock
FROM product p
LEFT JOIN category c
ON c.category_id = p.category_id
GROUP BY c.name;

-- Tính tổng tiền mỗi người đã đặt hàng (theo user_id).
SELECT u.user_id, 
SUM(o.total_amount) AS total_amountPerUser
FROM orders o
LEFT JOIN user u
ON u.user_id = o.user_id
GROUP BY u.user_id;

-- Tính số lượng đơn hàng của mỗi người dùng.
SELECT u.user_id, u.name,
SUM(od.quantity) AS total_quantity
FROM orders o
LEFT JOIN user u
ON u.user_id = o.user_id
LEFT JOIN  order_detail od 
ON o.order_id = od.order_id
GROUP BY u. name, u.user_id;

-- Đếm số lượng sản phẩm khác nhau trong từng đơn hàng
SELECT 
    o.order_id, 
    COUNT(DISTINCT od.product_id) AS different_products,
    GROUP_CONCAT(DISTINCT p.name) AS product_names
FROM orders o
JOIN order_detail od 
    ON o.order_id = od.order_id
JOIN product p
    ON od.product_id = p.product_id
GROUP BY o.order_id;

-- Liệt kê các người dùng có tổng số tiền đơn hàng > 10 triệu.
SELECT u.name, u.user_id, 
SUM(o.total_amount) AS total_amountByuser
FROM user u
JOIN orders o
ON u.user_id = o.user_id
GROUP BY u.name, u.user_id
HAVING SUM(o.total_amount) > 10000000;

