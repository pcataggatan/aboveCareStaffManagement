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



insert into user values (1001,"admin","king1","administrator", "king1admin@abovecare.com");
insert into user values (1002,"pabbs","prince2","biz_owner", "prince2owner@abovecare.com");
insert into user values (1003,"aileen","princess3","ofc_staff", "princess3@abovecare.com");
insert into user values (1004,"trixie","princess4","ofc_staff", "princess3@abovecare.com");

insert into user_roles values (2001,"admin", "administrator");
insert into user_roles values (2002,"pabbs", "biz_owner");
insert into user_roles values (2003,"aileen", "ofc_staff");
insert into user_roles values (2004,"trixie", "ofc_staff");
