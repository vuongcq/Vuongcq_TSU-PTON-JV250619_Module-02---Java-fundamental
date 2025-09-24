-- Tạo và sử dụng database
CREATE DATABASE ss6;
USE ss6;

-- Tạo bảng Orders
CREATE TABLE Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,              
    CustomerName VARCHAR(100) NOT NULL,                 
    ProductName VARCHAR(100) NOT NULL,                  
    Quantity INT NOT NULL CHECK (Quantity > 0),         
    Price DECIMAL(10, 2) NOT NULL CHECK (Price > 0),    
    OrderDate DATE NOT NULL                             
);

-- Thêm giá trị vào bảng Orders
INSERT INTO Orders (CustomerName, ProductName, Quantity, Price, OrderDate)
VALUES
    ('Nguyen Van A', 'Laptop', 1, 15000000, '2025-01-01'),
    ('Tran Thi B', 'Smartphone', 2, 8000000, '2025-01-01'),
    ('Nguyen Van A', 'Headphones', 3, 2000000, '2025-01-03'),
    ('Le Van C', 'Laptop', 1, 15000000, '2025-01-01'),
    ('Nguyen Van A', 'Smartphone', 1, 8000000, '2025-01-05'),
    ('Tran Thi B', 'Headphones', 1, 2000000, '2025-01-05'),
    ('Le Van C', 'Smartphone', 3, 8000000, '2025-01-07'),
    ('Tran Thi B', 'Laptop', 1, 15000000, '2025-01-03');
    
-- 2. Truy vấn để tính tổng số lượng sản phẩm đã đặt theo từng khách hàng.
-- Hiển thị các trường: tên khách hàng (CustomerName) và tổng số lượng sản phẩm đã đặt (TotalQuantity).

SELECT o.CustomerName, SUM(o.price) AS TotalQuantity
FROM orders o
GROUP BY o.customerName;

-- 3. tìm giá cao nhất của sản phẩm theo từng loại sản phẩm.
-- Hiển thị các trường: tên loại sản phẩm (ProductName) và giá cao nhất (MaxPrice).
SELECT o.ProductName, MAX(o.price) AS MaxPrice
FROM orders o
GROUP BY o.ProductName;

-- 4. đếm số lượng đơn hàng theo ngày đặt hàng.
-- Hiển thị các trường: ngày đặt hàng (OrderDate) và tổng số đơn hàng (TotalOrders).
SELECT o.OrderDate, SUM(o.Quantity) AS TotalOrder
FROM orders o
GROUP BY o.OrderDate;

-- 5. tìm giá thấp nhất của sản phẩm theo từng khách hàng.
-- Hiển thị các trường: tên khách hàng (CustomerName) và giá thấp nhất (MinPrice).

SELECT o.CustomerName, MIN(o.price) AS MinPrice
FROM orders o
GROUP BY o.CustomerName;

