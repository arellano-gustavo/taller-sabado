docker exec -it curso-db-2 bash
mysql -uroot -pgustavo


CREATE DATABASE prueba;
use prueba;
CREATE TABLE persona (
   id int,
   first varchar(64),
   last varchar(64),
   age int
);
INSERT INTO persona values(1,'carlos','salinas',25);
INSERT INTO persona values(2,'ernesto','zedillo',36);
INSERT INTO persona values(3,'vicente','fox',19);
INSERT INTO persona values(4,'felipe','caldeon',52);

