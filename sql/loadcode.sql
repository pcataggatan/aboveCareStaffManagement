drop table if exists `code`;

create table code (
  code_id   int(11) NOT NULL auto_increment,
  code      VARCHAR(3) NOT NULL,
  value     VARCHAR(5) NOT NULL,
  desc_tx   VARCHAR(30) NOT NULL,
  PRIMARY KEY (code_id)
); ENGINE=INNODB;

insert into code values (1,"C01","8.00","Client rate code tier 1");
insert into code values (2,"C02","9.00","Client rate code tier 2");
insert into code values (3,"C03","10.00","Client rate code tier 3");
insert into code values (4,"C04","11.00","Client rate code tier 4");
insert into code values (5,"C05","12.00","Client rate code tier 5");

insert into code values (6,"S01","5.00","Staff rate code tier 1");
insert into code values (7,"S02","5.50","Staff rate code tier 2");
insert into code values (8,"S03","6.00","Staff rate code tier 3");
insert into code values (9,"S04","6.50","Staff rate code tier 4");
insert into code values (10,"S05","7.00","Staff rate code tier 5");
insert into code values (11,"S06","8.50","Staff rate code tier 6");
insert into code values (12,"S07","7.00","Staff rate code tier 7");
insert into code values (13,"S08","8.50","Staff rate code tier 8");
insert into code values (14,"S09","7.00","Staff rate code tier 9");
insert into code values (15,"S10","8.50","Staff rate code tier 10");
