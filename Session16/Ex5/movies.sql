-- DROP DATABASE session16ex5;
CREATE DATABASE session16ex5;
USE session16ex5;

-- tạo bảng movies
CREATE table movies
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    title    varchar(100) NOT NULL,
    director varchar(100) NOT NULL,
    year     INT          NOT NULL
);

-- Stored procedure

DELIMITER //
-- thêm phim
CREATE PROCEDURE add_movie(
    IN title_in varchar(100),
    IN director_in varchar(100),
    IN year_in int
)
BEGIN
    INSERT INTO movies (title, director, year)
        VALUES (title_in, director_in, year_in);
end //

-- Liệt kê phim
CREATE PROCEDURE display_movie()
BEGIN
    SELECT * FROM movies;
end //
CALL display_movie();
-- Sửa phim
CREATE PROCEDURE edit_movie(
    IN id_in int,
    IN title_in varchar(100),
    IN director_in varchar(100),
    IN year_in int
)
BEGIN
    UPDATE movies
    SET title    = title_in,
        director = director_in,
        year     = year_in
    WHERE id = id_in;
end //

-- xóa phim
CREATE PROCEDURE delete_movie(
    IN id_in int
)
BEGIN
    DELETE
    FROM movies
    WHERE id = id_in;
end //

-- TÌm theo id
CREATE PROCEDURE find_movie_by_id (
    IN id_in int
)
    BEGIN
SELECT m.id,
       m.title,
       m.director,
       m.year
           FROM movies m
WHERE id_in = id;
END ;

DELIMITER ;

INSERT INTO movies (title, director, year)
VALUES ('Mắt Biếc', 'Victor Vũ', 2019),
       ('Hai Phượng', 'Lê Văn Kiệt', 2019),
       ('Em Chưa 18', 'Lương Đình Dũng', 2017),
       ('Tôi Thấy Hoa Vàng Trên Cỏ Xanh', 'Victor Vũ', 2015),
       ('Cô Gái Đến Từ Hôm Qua', 'Phan Gia Nhật Linh', 2016),
       ('Lật Mặt: Ba Chàng Khuyết', 'Lý Hải', 2017),
       ('Cha Cõng Con', 'Lương Đình Dũng', 2017),
       ('Song Lang', 'Leon Le', 2018),
       ('Bố Già', 'Trấn Thành', 2021),
       ('Ròm', 'Trần Thanh Huy', 2019);

CALL display_movie();