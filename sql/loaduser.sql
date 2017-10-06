drop table if exists `user`;

create table user (
  username  VARCHAR(15) NOT NULL,
  password  VARCHAR(15) NOT NULL,
  rolename      VARCHAR(15) NOT NULL,
  email     VARCHAR(50) NOT NULL,
  PRIMARY KEY (username)
); ENGINE=INNODB;

drop table if exists `user_roles`;

create table user_roles (
  username         varchar(15) not null,
  rolename         varchar(15) not null,
  PRIMARY KEY (username, rolename)
); ENGINE=INNODB;



insert into user values ("admin","king1","administrator", "king1admin@abovecare.com");
insert into user values ("pabbs","prince2","biz_owner", "prince2owner@abovecare.com");
insert into user values ("aileen","princess3","ofc_staff", "princess3@abovecare.com");

insert into user_roles values ('admin', 'administrator');
insert into user_roles values ('admin', 'biz_owner');
insert into user_roles values ('admin', 'ofc_staff');
insert into user_roles values ('pabbs', 'biz_owner');
insert into user_roles values ('pabbs', 'ofc_staff');
insert into user_roles values ('aileen', 'ofc_staff');
