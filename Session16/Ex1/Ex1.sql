CREATE database ss16ex1;
USE ss16ex1;

CREATE table students (
student_id int auto_increment Primary key,
full_name varchar(100) not null,
date_of_birth date not null,
email varchar(100) not null unique
);

-- viết các Stored Procedure
DELIMITER //
-- Lấy tất cả sinh viên
CREATE PROCEDURE get_all_students ()
BEGIN
SELECT*
FROM students;

END//

-- thêm sinh viên
CREATE PROCEDURE add_student(
IN in_full_name varchar(100), 
IN in_date_of_birth Date, 
IN in_email varchar(100))
BEGIN
INSERT INTO students (full_name, date_of_birth, email)
VALUES (in_full_name, in_date_of_birth, in_email);
END//

-- Cập nhật thông tin sinh viên
CREATE PROCEDURE update_student(
IN in_id int, 
IN in_full_name varchar(100),
IN in_date_of_birth Date,
IN in_email varchar(100)
)
BEGIN
UPDATE students
SET full_name = in_full_name,
 date_of_birth = in_date_of_birth,
 email = in_email
WHERE student_id = in_id;
END//

-- tìm sinh viên theo id
CREATE PROCEDURE find_student_by_id (
IN in_id int
)
BEGIN
SELECT*
FROM students
WHERE student_id = in_id;
END//

-- xóa sinh viên theo id
CREATE PROCEDURE delete_student(
IN in_id int
)
BEGIN
DELETE FROM students WHERE student_id = in_id;
END//

DELIMITER ;

INSERT INTO students (full_name, date_of_birth, email) VALUES
('Nguyễn Văn A', '2000-05-15', 'nguyenvana@example.com'),
('Trần Thị B', '2001-08-20', 'tranthib@example.com'),
('Lê Hoàng C', '1999-11-10', 'lehoangc@example.com'),
('Phạm Thu D', '2002-03-25', 'phạmthud@example.com'),
('Vũ Minh E', '2000-01-01', 'vuminhe@example.com'),
('Hoàng Yến F', '2001-06-30', 'hoangyenf@example.com'),
('Đặng Quốc G', '1998-09-12', 'dangquocg@example.com'),
('Bùi Thanh H', '2003-04-18', 'buitranhh@example.com'),
('Tô An I', '2000-12-05', 'toani@example.com'),
('Đinh Kiều K', '2002-07-22', 'dinhkieuk@example.com');


