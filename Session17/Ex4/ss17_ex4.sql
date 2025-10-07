-- DROP database ss17ex4;


CREATE DATABASE ss17ex4;
USE ss17ex4;

-- tạo bảng
CREATE TABLE accounts (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          balance DECIMAL(15, 2) NOT NULL
);

-- viết stored procedure
DELIMITER //
CREATE PROCEDURE transfer_funds(
    IN id_from INT,
    IN id_to INT,
    IN amount DECIMAL(15, 2),
    OUT result VARCHAR(255)
)
BEGIN
    DECLARE count_id_from INT DEFAULT 0;
    DECLARE count_id_to INT DEFAULT 0;
    DECLARE balance_from DECIMAL(15,2);

    -- kiểm tra người gửi và người nhận
    SELECT COUNT(id) INTO count_id_from FROM accounts WHERE id = id_from;
    SELECT COUNT(id) INTO count_id_to FROM accounts WHERE id = id_to;

    IF count_id_from = 0 THEN
        SET result = 'Không tìm thấy người gửi!';
    ELSEIF count_id_to = 0 THEN
        SET result = 'Không tìm thấy người nhận!';
    ELSE
        SELECT balance INTO balance_from FROM accounts WHERE id = id_from;

        IF balance_from < amount THEN
            SET result = 'Người gửi không đủ tiền!';
        ELSE
            UPDATE accounts SET balance = balance - amount WHERE id = id_from;
            UPDATE accounts SET balance = balance + amount WHERE id = id_to;
            SET result = 'Chuyển tiền thành công!';
        END IF;
    END IF;
END //
DELIMITER ;