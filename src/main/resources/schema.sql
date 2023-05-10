DROP TABLE if EXISTS astronaut;
CREATE TABLE astronaut (
    astronaut_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    craft VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (astronaut_id)
);

DROP TABLE if EXISTS author;
DROP TABLE if EXISTS book;
DROP TABLE if EXISTS author_book;

CREATE TABLE author (
    author_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (author_id)
);

CREATE TABLE book (
    book_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    PRIMARY KEY (book_id)
);

CREATE TABLE author_book (
    a_id INT NOT NULL,
    b_id INT NOT NULL
);

CREATE TABLE if NOT EXISTS interview_question (
    question_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    question VARCHAR(255) NOT NULL,
    answer VARCHAR(500) NOT NULL,
    PRIMARY KEY (question_id)
);