-- Xóa toàn bộ dữ liệu.
DROP database library_management;

-- add lại
-- Tạo database với tên library_management
CREATE database library_management;
USE library_management;
-- Tạo bảng
CREATE table books (
bookId int primary key,
title  varchar(100) NOT NULL UNIQUE,
author varchar (50) NOT NULL,
publishedYear int NOT NULL,
category varchar (50) NOT NULL
);

CREATE table readers (
readerId int auto_increment primary key,
name varchar(50) NOT NULL,
birthDate  date NOT NULL check(birthDate >'1900-01-01'),
address varchar(50),
phoneNumber varchar(11)
);

CREATE table borrows (
borrowId int auto_increment primary key,
borrowDate date NOT NULL, -- CHECK (borrowDate <= CURDATE()),
returnDate date,
bookId int,
readerId int,
FOREIGN KEY (bookId) REFERENCES books(bookId),
FOREIGN KEY (readerId) REFERENCES readers(readerId)
);

-- Ex3
-- chèn 10 bản ghi vào Books
INSERT INTO books (bookId, title, author, publishedYear, category)
VALUES (1, 'Số đỏ', 'Vũ Trọng Phụng', 2009, 'Sách hài');
INSERT INTO books (bookId, title, author, publishedYear, category)
VALUES (2, 'Số đen', 'Vũ Trọng Táo', 2010, 'Kiếm hiệp');
INSERT INTO books (bookId, title, author, publishedYear, category)
VALUES (3, 'A', 'Vũ Trọng Phụng', 2009, 'Sách hài');
INSERT INTO books (bookId, title, author, publishedYear, category)
VALUES (4, 'B', 'Vũ Trọng Phụng', 2009, 'Sách hài');
INSERT INTO books (bookId, title, author, publishedYear, category)
VALUES (5, 'C', 'Vũ Trọng Phụng', 2009, 'Sách hài');
INSERT INTO books (bookId, title, author, publishedYear, category)
VALUES (6, 'D', 'Vũ Trọng Phụng', 2009, 'Sách hài');
INSERT INTO books (bookId, title, author, publishedYear, category)
VALUES (7, 'E', 'Vũ Trọng Phụng', 2009, 'Sách hài');
INSERT INTO books (bookId, title, author, publishedYear, category)
VALUES (8, 'F', 'Vũ Trọng Phụng', 2009, 'Sách hài');
INSERT INTO books (bookId, title, author, publishedYear, category)
VALUES (9, 'G', 'Vũ Trọng Phụng', 2009, 'Sách hài');
INSERT INTO books (bookId, title, author, publishedYear, category)
VALUES (10, 'H', 'Vũ Trọng Phụng', 2009, 'Sách hài');

-- UPDATE
UPDATE books
SET author = 'Nguyễn Văn A'
WHERE bookid=1;

-- lấy ra cuốn sách có tiêu đề là chữ A và B
SELECT title
FROM books
WHERE title LIKE 'A%' OR title LIKE 'B%';

-- EX4
-- Thêm 10 bản ghi
INSERT INTO readers (name, birthDate, address, phoneNumber )
VALUES ('Nguyễn Văn A', '1992-05-15', 'Hà Nội', '0123456789'),
('Trần Thị B', '1985-08-20', 'TP Hồ Chí Minh', '0987654321'),
('Lê Văn C', '1970-12-10', 'Đà Nẵng', '0112233445'),
('Phạm Thị D', '1995-03-30', 'Cần Thơ', '0198765432'),
('Nguyễn Văn E', '1980-07-22', 'Hải Phòng', '0123987654'),
('Trần Văn F', '1965-11-05', 'Nha Trang', '0156789012'),
('Lê Thị G', '1998-01-25', 'Biên Hòa', '0167890123'),
('Phạm Văn H', '1982-09-15', 'Vũng Tàu', '0178901234'),
('Nguyễn Thị I', '1973-04-18', 'Thủ Dầu Một', '0189012345'),
('Trần Văn J', '1990-06-12', 'Đà Lạt', '0190123456');

-- nối thêm genZ vào trường name của độc giẩ sinh từ 1990-2000
UPDATE readers
SET name = CONCAT(name, 'genZ')
WHERE birthDate BETWEEN '1990-01-01' AND '2000-12-31';

-- thực hiện truy  vấn
SELECT * FROM readers
WHERE birthDate < '1975-01-01';

-- EX5
-- Chèn ít nhất 10 bản ghi vào bảng borrows
INSERT INTO borrows (borrowDate, returnDate, bookId, readerId)
VALUES ('2023-06-12', '2023-06-17',1,1),
('2023-06-12', '2023-06-17',2,2),
('2023-07-12', '2023-07-17',3,3),
('2023-08-12', '2023-08-17',4,4),
('2023-09-12', '2023-09-17',5,5),
('2023-03-12', '2023-03-17',6,6),
('2023-04-12', '2023-04-17',7,7),
('2023-01-12', '2023-01-17',8,8),
('2023-04-12', '2023-04-17',9,9),
('2023-05-12', '2023-05-17',10,10);

UPDATE borrows 
SET returnDate = NOW()
WHERE borrowId =2;

-- truy vấn dữ liệu lấy ra những phiếu mượn có bookId =2
SELECT *
FROM borrows
WHERE bookId = 2
  AND returnDate IS NOT NULL;
  
  -- EX6
  -- Xóa độc giả khỏi bảng reader nếu k có phiệu mượn nào liên quan đến tác giả đó
  DELETE FROM readers
  WHERE NOT EXISTS (
    SELECT 1
    FROM borrows
    WHERE borrows.readerId = readers.readerId
);
-- Xpá 1 cuốn sách trong bảng books nếu sách đó không bị mượn
DELETE FROM books
WHERE NOT EXISTS (
    SELECT 1
    FROM borrows
    WHERE borrows.bookId = books.bookId
);
-- Xóa 1 phiếu mượn khỏi bảng borrows
DELETE FROM borrows  WHERE  borrowId =2;

  







