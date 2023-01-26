CREATE TABLE IF NOT EXISTS event(
    id SERIAL NOT NULL,
    description VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    total_attendees INT,
    city VARCHAR(50),
    PRIMARY KEY (id)
);