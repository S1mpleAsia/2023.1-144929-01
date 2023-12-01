-- Create DB schema if it does not exist

/* Account Table */
CREATE TABLE IF NOT EXISTS account
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    username  VARCHAR(50),
    password  VARCHAR(50),
    role VARCHAR(50),
    employeeId INT
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
    employeeId VARCHAR(20),
    name VARCHAR(50),
    gender VARCHAR(10),
    age INT,
    department_id INT,
    type INT
);

/* Record Table */
CREATE TABLE IF NOT EXISTS record
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    employeeId VARCHAR(20),
    check_time TIMESTAMP
);

-- Insert data into database
INSERT INTO account (username, password, role, employeeId)
VALUES ('s1mpleasia', '123456', 'Manager', 1),
       ('lecuong', '123456', 'Worker', 2),
       ('vuz', '123456', 'HR', 3);

INSERT INTO employee (employeeId, name, gender, age, department_id, type)
VALUES ('BK_20200125', 'Vũ Tùng Dương', 'Male', 22, 1, 2),
       ('BK_20204637', 'Lê Thạch Cương', 'Female', 22, 1, 3),
       ('NEU_20204625', 'Nguyễn Thế Vũ', 'Male', 20, 2, 1),
       ('NEU_20201234', 'Lê Quang Nghị', 'Male', 21, 2, 2);

INSERT INTO department (manager_id, department_name)
VALUES ('4', 'Đại học Kinh tế Quốc dân'),
       ('1', 'Đại học Bách Khoa Hà Nội');