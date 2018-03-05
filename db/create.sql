CREATE DATABASE mysqldb;
CREATE USER 'cd'@'%' IDENTIFIED BY 'passme';
GRANT ALL ON mysqldb.* TO 'cd';
