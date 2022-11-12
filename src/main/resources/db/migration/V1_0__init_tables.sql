CREATE TABLE IF NOT EXISTS authentication.user(
    id int NOT NULL,
    username VARCHAR(15) NOT NULL,
    password VARCHAR(30) NOT NULL,
    confirm_password VARCHAR(30) NOT NULL,
    email VARCHAR(100),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE SEQUENCE authentication.SQ_USER
    START 1
    INCREMENT 1;

CREATE INDEX idx_user_id ON authentication.user(id);