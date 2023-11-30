CREATE TABLE user
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    username  VARCHAR(50),
    password  VARCHAR(50),
    user_role VARCHAR(50)
);

INSERT INTO user (username, password, user_role)
VALUES ('s1mpleasia', '123456', 'Department Leader'),
       ('lecuong', '123456', 'Employee'),
       ('vuz', '123456', 'HR')