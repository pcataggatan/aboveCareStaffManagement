drop table if exists `user`;

create table user (
  user_id   int(11) NOT NULL auto_increment,
  username  VARCHAR(15) NOT NULL,
  password  VARCHAR(16) NOT NULL,
  role      VARCHAR(10) NOT NULL,
  email     VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_id, username)
); ENGINE=INNODB;

insert into user values (1,"pabbs","theking#01","Owner", "pabscataggatan@yahoo.com");
insert into user values (2,"aileen","thequeen#01","Assistant", "pablocataggatan@gmail.com");

