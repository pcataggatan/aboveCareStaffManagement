drop table if exists `user`;

create table user (

  username  VARCHAR(15) NOT NULL,
  password  VARCHAR(16) NOT NULL,
  role      VARCHAR(10) NOT NULL,
  email     VARCHAR(50) NOT NULL,
  PRIMARY KEY (username)
); ENGINE=INNODB;

insert into user values ("pabbs","theking#01","Owner", "pabscataggatan@yahoo.com");
insert into user values ("aileen","thequeen#01","Assistant", "pablocataggatan@gmail.com");

