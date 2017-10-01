drop table if exists `sched`;

create table sched (
  staff_id        int(11) NOT NULL,
  client_id       int(11) NOT NULL,
  days_of_wk      varchar(7) NOT NULL,
  start_tm        TIME NOT NULL,
  end_tm          TIME NOT NULL
); ENGINE=INNODB;


insert into sched VALUES
(10001,90006, "135", '6:00', '9:00');

insert into sched VALUES
(10001,90000, "135", '13:00', '18:00');




FOREIGN KEY fk_staff_id (staff_id)
REFERENCES staff(staff_id)
ON DELETE CASCADE,
  FOREIGN KEY fk_client_id (client_id)
REFERENCES client(client_id)
ON DELETE CASCADE