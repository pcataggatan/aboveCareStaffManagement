drop table if exists `code`;

create table code (
  code      VARCHAR(3) NOT NULL,
  value     VARCHAR(5) NOT NULL,
  desc_tx   VARCHAR(30) NOT NULL,
  PRIMARY KEY (code)
); ENGINE=INNODB;

insert into code values ("C01","8.00","Client rate code tier 1");
insert into code values ("C02","9.00","Client rate code tier 2");
insert into code values ("C03","10.00","Client rate code tier 3");
insert into code values ("C04","11.00","Client rate code tier 4");
insert into code values ("C05","12.00","Client rate code tier 5");

insert into code values ("S01","5.00","Staff rate code tier 1");
insert into code values ("S02","5.50","Staff rate code tier 2");
insert into code values ("S03","6.00","Staff rate code tier 3");
insert into code values ("S04","6.50","Staff rate code tier 4");
insert into code values ("S05","7.00","Staff rate code tier 5");
insert into code values ("S06","8.50","Staff rate code tier 6");
insert into code values ("S07","7.00","Staff rate code tier 7");
insert into code values ("S08","8.50","Staff rate code tier 8");
insert into code values ("S09","7.00","Staff rate code tier 9");
insert into code values ("S10","8.50","Staff rate code tier 10");
