drop table if exists `sched`;

create table staff (
  staff_id        int(11) NOT NULL,
  client_id       int(11) NOT NULL,
  day_of_week     int(11) NOT NULL,
  am_start_tm     LocalTime,
  am_end_time     LocalTime,
  pm_start_tm     LocalTime,
  pm_end_time     LocalTime,
  PRIMARY KEY (staff_id),
  FOREIGN KEY (client_id)
);

insert into staff VALUES
(1

);

