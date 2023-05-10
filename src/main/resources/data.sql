INSERT INTO astronaut(craft, name) VALUES ('USS Enterprise', 'Kirk');
INSERT INTO astronaut(craft, name) VALUES ('USS Enterprise', 'Spock');
INSERT INTO astronaut(craft, name) VALUES ('USS Enterprise', 'Scotty');
INSERT INTO astronaut(craft, name) VALUES ('Millennium Falcon', 'Han Solo');

-- Insert author data
INSERT INTO author (name) VALUES ('Stanisław Lem');

-- Insert book data
INSERT INTO book (title) VALUES ('Głos Pana');
INSERT INTO book (title) VALUES ('Solaris');

-- Insert author-book relationship data
INSERT INTO author_book (a_id, b_id) VALUES (1, 1);
INSERT INTO author_book (a_id, b_id) VALUES (1, 2);