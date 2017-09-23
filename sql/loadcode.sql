drop table if exists `code`;

create table code (
  code      VARCHAR(3) NOT NULL,
  value     VARCHAR(5) NOT NULL,
  desc_tx   VARCHAR(30) NOT NULL,
  PRIMARY KEY (code)
);

insert into code values ("C01","8.00","Client rate code tier 01");
insert into code values ("C02","9.00","Client rate code tier 02");
insert into code values ("S01","5.00","Staff rate code tier 01");
insert into code values ("S02","5.50","Staff rate code tier 02");