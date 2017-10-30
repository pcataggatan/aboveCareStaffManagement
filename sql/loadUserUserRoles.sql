drop table if exists `user_roles`;
drop table if exists `user`;

create table user (
  user_id     int(11) NOT NULL auto_increment,
  username    VARCHAR(15) NOT NULL,
  password    VARCHAR(15) NOT NULL,
  rolename    VARCHAR(15) NOT NULL,
  email       VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY (username)
) ENGINE=INNODB;



create table user_roles (
  user_roles_id    int(11) NOT NULL auto_increment,
  username         varchar(15) not null,
  rolename         varchar(15) not null,
  PRIMARY KEY (user_roles_id)
) ENGINE=INNODB;



insert into user values (1001,"admin","king","administrator", "kingadmin@abovecare.com");
insert into user values (1002,"pabbs","mybiz","biz_owner", "princeowner@abovecare.com");
insert into user values (1005,"paula","waite","biz_owner", "paulawaite@abovecare.com");
insert into user values (1006,"waite","paula","ofc_staff", "waitepaula@abovecare.com");

insert into user_roles values (2001,"admin", "administrator");
insert into user_roles values (2002,"pabbs", "biz_owner");
insert into user_roles values (2003,"paula", "biz_owner");
insert into user_roles values (2004,"waite", "ofc_staff");
