CREATE DATABASE IF NOT EXISTS mini_jdbc;
USE mini_jdbc;

CREATE TABLE IF NOT EXISTS users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL
);

INSERT INTO users(username, password) VALUES
('venky', '1234'),
('admin', 'admin');

SELECT * FROM users;
