DROP TABLE teacher IF EXISTS;

CREATE TABLE teacher (
    id                  INTEGER IDENTITY PRIMARY KEY,
    name                VARCHAR(30),
    school              VARCHAR,
    experience          INTEGER
);