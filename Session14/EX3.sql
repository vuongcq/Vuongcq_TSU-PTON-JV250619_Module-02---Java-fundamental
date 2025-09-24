-- Sử dụng lại CSDL ss5 để thực hành lại bài này 
use ss5;
-- Tạo bảng students
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15)
);

-- Tạo bảng courses
CREATE TABLE courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    duration INT NOT NULL,
    fee DECIMAL(10, 2) NOT NULL
);

-- Tạo bảng enrollments
CREATE TABLE enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
-- Thêm bản ghi vào bảng students
INSERT INTO students (name, email, phone)
VALUES
('Nguyen Van An', 'nguyenvanan@example.com', '0901234567'),
('Tran Thi Bich', NULL, '0912345678'),
('Le Van Cuong', 'levancuong@example.com', NULL),
('Pham Minh Hoang', 'phamminhhoang@example.com', '0934567890'),
('Do Thi Ha', NULL, NULL),
('Hoang Quang Huy', 'hoangquanghuy@example.com', '0956789012');



-- Thêm bản ghi vào bảng cources
INSERT INTO courses (course_name, duration, fee)
VALUES
('Python Basics', 30, 500000),
('Web Development', 50, 1000000),
('Data Science', 40, 1500000),
('Machine Learning', 60, 2000000),
('UI/UX Design', 20, 800000);

-- Thêm bản ghi vào bảng enrollments
INSERT INTO enrollments (student_id, course_id, enrollment_date)
VALUES
(1, 1, '2025-01-10'), 
(2, 2, '2025-01-11'), 
(3, 3, '2025-01-12'), 
(4, 1, '2025-01-13'), 
(6, 2, '2025-01-15'), 
(1, 2, '2025-01-16'), 
(2, 3, '2025-01-17'), 
(3, 1, '2025-01-18');

-- 2. lấy tên học viên (student_name), email (email), tên khóa học (course_name), học phí (fee), 
-- và ngày đăng ký (enrollment_date).
-- Chỉ lấy học viên có ngày đăng ký nằm trong khoảng '2025-01-12' đến '2025-01-18' và học phí trên 800,000.

SELECT 
    s.name, 
    s.email, 
    c.course_name, 
    c.fee, 
    e.enrollment_date
FROM enrollments e
JOIN students s ON e.student_id = s.student_id
JOIN courses c ON e.course_id = c.course_id
WHERE e.enrollment_date BETWEEN '2025-01-12' AND '2025-01-18'
  AND c.fee > 800000
ORDER BY fee DESC;

-- 3. Truy vấn để lấy tên học viên (student_name), tên khóa học (course_name),
--  và học phí (fee) cho những học viên đăng ký khóa học có học phí dưới 1,000,000 
-- hoặc không thuộc khóa học "Python Basics". Giới hạn 5 kết quả đầu tiên.

SELECT st.name, co.course_name, co.fee
FROM enrollments e
JOIN students st ON e.student_id = st.student_id
JOIN courses co ON e.course_id = co.course_id
WHERE co.fee <1000000 OR co.course_name !='Python Basics'
LIMIT 5;

-- 4. lấy tên học viên (student_name), tên khóa học (course_name), học phí (fee), và ngày đăng ký (enrollment_date) 
-- cho những học viên đã đăng ký khóa học có tên "Web Development" hoặc "Data Science".
-- Kết quả sắp xếp theo ngày đăng ký tăng dần và giới hạn 3 kết quả đầu tiên. 

SELECT st.name, co.course_name, co.fee, e.enrollment_date
FROM enrollments e
JOIN students st ON e.student_id = st.student_id
JOIN courses co ON e.course_id = co.course_id
WHERE co.course_name = 'Web Development' OR 'Data Science'
ORDER BY e.enrollment_date ASC
LIMIT 3;