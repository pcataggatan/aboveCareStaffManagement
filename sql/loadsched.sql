drop table if exists `sched`;

create table sched (
  staff_id        int(11) NOT NULL,
  client_id       int(11) NOT NULL,
  day_of_week     int(1) NOT NULL,
  am_start_tm     TIME,
  am_end_time     TIME,
  pm_start_tm     TIME,
  pm_end_tm       TIME,
  PRIMARY KEY (staff_id)
); ENGINE=INNODB;


