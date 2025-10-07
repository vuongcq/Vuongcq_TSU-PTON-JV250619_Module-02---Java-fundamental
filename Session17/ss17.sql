DROP
database ss17;
-- tạo CSDL
CREATE
database ss17;
USE
ss17;

-- tạo bảng
CREATE table students
(
    id   INT primary key auto_increment,
    name varchar(100),
    age  int
);

-- tạo stored procedure
DELIMITER
//
-- Thêm mới sinh viên

CREATE procedure add_students(
    IN input_name varchar (100),
    IN input_age INT
)
BEGIN
INSERT INTO students (name, age)
VALUES (input_name, input_age);
END
//

-- Cập nhật sinh viên
CREATE procedure update_student(
    IN update_id int,
    IN update_name varchar (100),
    IN update_age INT
)
BEGIN
UPDATE students
SET name = update_name,
    age  = update_age
WHERE id = update_id;
END
//

-- Xóa dữ liệu dựa trên độ tuổi
CREATE procedure delete_students_by_age(
    del_by_age int
)
BEGIN
DELETE
FROM students
WHERE age < del_by_age;
END
//

DELIMITER ;
