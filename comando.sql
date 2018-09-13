DROP TABLE IF EXISTS temporal;
CREATE TABLE temporal (c1 INT, c2 VARCHAR(10));
INSERT INTO temporal (c1,c2) VALUES (1, 'a');
INSERT INTO temporal (c1,c2) VALUES (2, 'b'), (3, 'c');