drop database IF EXISTS mttmsg;
create database mttmsg;
use mttmsg;
create table mymtt(
	id INT PRIMARY KEY AUTO_INCREMENT,
	school VARCHAR(100),
	message text,
	manufacturer VARCHAR(100),
	time VARCHAR(100)
)ENGINE=MYISAM DEFAULT CHARSET=utf8;
