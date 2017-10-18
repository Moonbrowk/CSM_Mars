
-- Create Schema
CREATE  SCHEMA new_schema();

-- Table User
CREATE TABLE new_schema.users(
  id BIGSERIAL PRIMARY KEY NOT NULL ,
  username VARCHAR(10) NOT NULL ,
  psw VARCHAR(255) NOT NULL
);
-- Table Role

CREATE TABLE new_schema.roles(
  id BIGSERIAL NOT NULL PRIMARY KEY ,
  name VARCHAR(100) NOT NULL
);
-- Table User_Roles

CREATE TABLE new_schema.users_roles(
  user_id BIGSERIAL NOT NULL UNIQUE ,
  role_id BIGSERIAL NOT NULL UNIQUE ,

  FOREIGN KEY (user_id) REFERENCES new_schema.users (id),
  FOREIGN KEY (role_id) REFERENCES new_schema.roles (id)

);

-- insert
-- Add User pass "red"
INSERT INTO new_schema.users VALUES('1', 'Gozzz', '349e686330723975502e9ef4f939a5ac');
-- Add Roles
INSERT INTO new_schema.roles VALUES('1', 'admin');
INSERT INTO new_schema.roles VALUES('2', 'user');
-- Add User Roles
INSERT INTO new_schema.users_roles VALUES('1', '1');



