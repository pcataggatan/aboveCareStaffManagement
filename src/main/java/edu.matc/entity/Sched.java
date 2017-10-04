package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalTime;


@Entity
@Table(name = "sched")
public class Sched {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "sched_id")
    private int schedId;

    @Column (name = "staff_id")
    private int staffId;

    @Column (name = "client_id")
    private int clientId;

    @Column (name = "days_of_wk")
    private String daysOfWeek;

    @Column (name = "start_tm")
    private LocalTime startTime;

    @Column (name = "end_tm")
    private LocalTime endTime;


    public Sched() {}

    public Sched(int schedId, int staffId, int clientId, String daysOfWeek,
                 LocalTime startTime, LocalTime endTime) {
        this.schedId = schedId;
        this.staffId = staffId;
        this.clientId = clientId;
        this.daysOfWeek = daysOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
