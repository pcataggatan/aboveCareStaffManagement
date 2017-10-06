drop table if exists `sched`;

create table sched (
  sched_id        int(11) NOT NULL auto_increment,
  staff_id        int(11) NOT NULL,
  client_id       int(11) NOT NULL,
  days_of_wk      varchar(7),
  start_tm        TIME NOT NULL,
  end_tm          TIME NOT NULL,
  FOREIGN KEY (staff_id)
  REFERENCES staff (staff_id)
    ON DELETE CASCADE,
  FOREIGN KEY (client_id)
  REFERENCES client (client_id)
    ON DELETE CASCADE,
  PRIMARY KEY  (sched_id)
) ENGINE=INNODB;


insert into sched VALUES (1,10001,90001, "135", '6:00', '9:00');
insert into sched VALUES (2,10001,90000, "135", '13:00', '18:00');
insert into sched VALUES (3,10001,90000, "2467", '6:00', '18:00');
