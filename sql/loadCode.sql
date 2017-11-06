drop table if exists `code`;

create table `code` (
`code`   VARCHAR(3) NOT NULL,
`value`     VARCHAR(6) NOT NULL,
`desc_tx`   VARCHAR(40) NOT NULL,
PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


insert into `code` values ("C01","10.25","Client rate code tier 1");
insert into `code` values ("C02","12.25","Client rate code tier 2");
insert into `code` values ("C03","14.25","Client rate code tier 3");
insert into `code` values ("C04","16.25","Client rate code tier 4");
insert into `code` values ("C05","18.25","Client rate code tier 5");
insert into `code` values ("C06","20.25","Client rate code tier 6");
insert into `code` values ("C07","22.25","Client rate code tier 7");
insert into `code` values ("C08","24.25","Client rate code tier 8");
insert into `code` values ("C09","26.25","Client rate code tier 9");
insert into `code` values ("C10","28.25","Client rate code tier 10");
insert into `code` values ("C11","30.25","Client rate code tier 11");


insert into `code` values ("S01","5.75","Staff rate code tier 1");
insert into `code` values ("S02","6.75","Staff rate code tier 2");
insert into `code` values ("S03","7.75","Staff rate code tier 3");
insert into `code` values ("S04","8.75","Staff rate code tier 4");
insert into `code` values ("S05","9.75","Staff rate code tier 5");
insert into `code` values ("S06","10.75","Staff rate code tier 6");
insert into `code` values ("S07","11.75","Staff rate code tier 7");
insert into `code` values ("S08","12.75","Staff rate code tier 8");
insert into `code` values ("S09","13.75","Staff rate code tier 9");
insert into `code` values ("S10","14.75","Staff rate code tier 10");
insert into `code` values ("S11","15.75","Staff rate code tier 11");
insert into `code` values ("S12","16.75","Staff rate code tier 12");
insert into `code` values ("S13","17.75","Staff rate code tier 13");
insert into `code` values ("S14","18.75","Staff rate code tier 14");
insert into `code` values ("S15","19.75","Staff rate code tier 15");
