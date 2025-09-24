-- Sử dụng lại CSDL ss5 để thực hành lại bài này 
use ss5;
-- Tạo bảng products
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY, 
    product_name VARCHAR(100) NOT NULL,        
    category VARCHAR(50) NOT NULL,            
    price DECIMAL(10, 2) NOT NULL,            
    stock_quantity INT NOT NULL               
);

-- Thêm bản ghi vào products
INSERT INTO products (product_name, category, price, stock_quantity)
VALUES
('Laptop Dell XPS 13', 'Electronics', 25999.99, 10),
('Nike Air Max 270', 'Footwear', 4999.00, 50),
('Samsung Galaxy S22', 'Electronics', 19999.99, 25),
('T-Shirt Uniqlo', 'Clothing', 299.99, 100),
('Apple AirPods Pro', 'Accessories', 5999.00, 15),
('T-Shirt Apolo', 'Clothing', 199.99, 100);

-- 1.  lấy thông tin các sản phẩm từ bảng dữ liệu bao gồm các trường:
-- product_id và product_name (có sẵn trong bảng),
-- price (giá hiện tại, có sẵn trong bảng),
-- new_price (giá mới được tính bằng cách tăng giá hiện tại lên 10%).

SELECT p.product_id, p.product_name, p.price, (p.price * 1.1) AS new_price
FROM products p;

-- 2. truy vấn để tính tổng số tiền tồn kho của sản phẩm.
--  Kết quả trả về các trường product_id, product_name, price, stock_quantity, 
-- total_stock_value (được tính bằng price * stock_quantity)

SELECT p.product_id, p.product_name, p.price, p.stock_quantity, (price * stock_quantity) AS total_stock_value
FROM products p;

-- 3. lọc các sản phẩm thuộc danh mục Electronics hoặc có giá trên 20,000. 
-- Kết quả trả về các trường product_id, product_name, category, price
SELECT p.product_id, p.product_name, p.category, p.price
FROM products p
WHERE p.category = 'electronics' OR p.price > 20000;
