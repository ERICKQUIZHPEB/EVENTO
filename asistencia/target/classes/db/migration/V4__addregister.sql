CREATE TABLE IF NOT EXISTS register(
    id SERIAL NOT NULL,
    member_id INT NOT NULL,
    conference_id INT NOT NULL,
    code VARCHAR(20) NOT NULL,
    registered_at VARCHAR(50) NOT NULL,
    assisted INT NOT NULL,
    PRIMARY KEY(id),
    UNIQUE(code),
    FOREIGN KEY(member_id) REFERENCES member(id),
    FOREIGN KEY(conference_id) REFERENCES conference(id)
);