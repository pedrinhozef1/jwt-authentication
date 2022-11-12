CREATE TABLE IF NOT EXISTS authentication.user(
    id int NOT NULL,
    username VARCHAR(15) NOT NULL,
    password VARCHAR(30) NOT NULL,
    confirmPassword VARCHAR(30) NOT NULL,
    email VARCHAR(100),
    createdAt TIMESTAMP NOT NULL,
    updatedAt TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE SEQUENCE authentication.SQ_USER
    START 1
    INCREMENT 1;

CREATE INDEX idx_user_id ON authentication.user(id);