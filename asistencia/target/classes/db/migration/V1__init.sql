CREATE TABLE IF NOT EXISTS member(
    id SERIAL NOT NULL,
    fullname VARCHAR(10) NOT NULL,
    email VARCHAR(100) NOT NULL,
    age INT,
    PRIMARY KEY (id)
    );