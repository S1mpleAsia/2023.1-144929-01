-- Create DB schema if it does not exist

/* Account Table */
CREATE TABLE IF NOT EXISTS account
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    username  VARCHAR(50),
    password  VARCHAR(50),
    role VARCHAR(50),
    employee_id INT
);

/* Department Table */
CREATE TABLE IF NOT EXISTS department
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    manager_id INT,
    department_name VARCHAR(100)
);

/* Employee Table */
CREATE TABLE IF NOT EXISTS employee
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id VARCHAR(20),
    name VARCHAR(50),
    gender VARCHAR(10),
    age INT,
    department_id INT,
    type VARCHAR(25)
);

/* Record Table */
CREATE TABLE IF NOT EXISTS record
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id VARCHAR(20),
    check_time TIMESTAMP
);

-- Insert data into database
INSERT INTO account (username, password, role, employee_id)
VALUES ('s1mpleasia', '123456', 'Manager', 1),
       ('lecuong', '123456', 'Worker', 2),
       ('vuz', '123456', 'HR', 3);

INSERT INTO employee (employee_id, name, gender, age, department_id, type)
VALUES ('BK_20200125', 'Vũ Tùng Dương', 'Male', 22, 1,'Manager'),
       ('BK_20204637', 'Lê Thạch Cương', 'Female', 22, 1, 'Officer'),
       ('NEU_20204625', 'Nguyễn Thế Vũ', 'Male', 20, 2, 'Worker'),
       ('NEU_20201234', 'Lê Quang Nghị', 'Male', 21, 2, 'HR');

INSERT INTO department (manager_id, department_name)
VALUES ('1', 'Đại học Bách Khoa Hà Nội'),
       ('4', 'Đại học Kinh tế Quốc dân');

INSERT INTO record (employee_id, check_time)
VALUES (1, '2023-12-04 07:55:20'),
       (1, '2023-12-04 09:32:12'),
       (1, '2023-12-04 12:02:23'),
       (1, '2023-12-04 14:30:32'),
       (1, '2023-12-04 17:35:40'),
       (3, '2023-12-04 07:55:20'),
       (3, '2023-12-04 09:32:12'),
       (3, '2023-12-04 12:02:23'),
       (3, '2023-12-04 14:30:32'),
       (3, '2023-12-04 17:35:40'),
       (4, '2023-12-04 07:55:20'),
       (4, '2023-12-04 09:32:12'),
       (4, '2023-12-04 12:02:23'),
       (4, '2023-12-04 14:30:32'),
       (4, '2023-12-04 17:35:40');
