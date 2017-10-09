package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table (name = "sched")
public class Sched {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "sched_id", nullable = false)
    private int schedId;

    @Column(name = "start_tm", nullable = false)
    private LocalTime startTm;

    @Column(name = "end_tm", nullable = false)
    private LocalTime endTm;

    @Column(name = "days_of_wk", nullable = false, length = 10)
    private String daysOfWk;

    //@JoinColumn(name = "assign_id", referencedColumnName = "assign_id", nullable = false)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assign_id", nullable = false)
    private Assignment assignment;

    public Sched() {
    }

    //public Sched(int schedId, int assignId, LocalTime startTm, LocalTime endTm, String daysOfWk,
    //           Assignment assignmentByAssignId) {
    public Sched(int schedId, LocalTime startTm, LocalTime endTm, String daysOfWkAssignment,
                 Assignment assignment) {
        this.schedId = schedId;
        this.startTm = startTm;
        this.endTm = endTm;
        this.daysOfWk = daysOfWk;
        this.assignment = assignment;
    }



    public int getSchedId() {
        return schedId;
    }

    public void setSchedId(int schedId) {
        this.schedId = schedId;
    }


    public LocalTime getStartTm() {
        return startTm;
    }

    public void setStartTm(LocalTime startTm) {
        this.startTm = startTm;
    }


    public LocalTime getEndTm() {
        return endTm;
    }

    public void setEndTm(LocalTime endTm) {
        this.endTm = endTm;
    }


    public String getDaysOfWk() {
        return daysOfWk;
    }

    public void setDaysOfWk(String daysOfWk) {
        this.daysOfWk = daysOfWk;
    }



    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sched sched = (Sched) o;

        if (schedId != sched.schedId) return false;
        if (startTm != null ? !startTm.equals(sched.startTm) : sched.startTm != null) return false;
        if (endTm != null ? !endTm.equals(sched.endTm) : sched.endTm != null) return false;
        if (daysOfWk != null ? !daysOfWk.equals(sched.daysOfWk) : sched.daysOfWk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedId;
        result = 31 * result + (startTm != null ? startTm.hashCode() : 0);
        result = 31 * result + (endTm != null ? endTm.hashCode() : 0);
        result = 31 * result + (daysOfWk != null ? daysOfWk.hashCode() : 0);
        return result;
    }

}
