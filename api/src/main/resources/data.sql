DROP TABLE IF EXISTS users;
 
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  birth_date DATE NOT NULL,
  country VARCHAR(250) NOT NULL,
  phone_number VARCHAR(250),
  gender VARCHAR(10)
);
 
INSERT INTO users (user_name, birth_date, country, phone_number, gender) VALUES
  ('Youssef', '1993-01-21', 'France', '0123456789', 'MALE'),
  ('Joy', '2005-01-21', 'France', '0123474789', 'MALE'),
  ('you', '1995-01-28', 'France', '0123457489', 'MALE');