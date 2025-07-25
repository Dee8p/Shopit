-- for the shop

CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2),
    stock INT,
    images TEXT 
);

CREATE TABLE IF NOT EXISTS cart (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2),
    quantity INT
    
); 

CREATE TABLE sec_user
(
    userId            BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email             VARCHAR(75)  NOT NULL UNIQUE,
    encryptedPassword VARCHAR(128) NOT NULL,
    enabled           BIT          NOT NULL
); 

CREATE TABLE sec_role
(
    roleId   BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    roleName VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE user_role
(
    id     BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userId BIGINT NOT NULL,
    roleId INT NOT NULL
);

ALTER TABLE user_role
    ADD CONSTRAINT user_role_uk UNIQUE (userId, roleId);

ALTER TABLE user_role
    ADD CONSTRAINT user_role_fk1 FOREIGN KEY (userId)
        REFERENCES sec_user (userId);

ALTER TABLE user_role
    ADD CONSTRAINT user_role_fk2 FOREIGN KEY (roleId)
        REFERENCES sec_role (roleId);
