package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "timesheet")
public class TimeSheet {

    private int timeId;
    private int hoursWorked;
    private Staff staffByStaffId;


    public TimeSheet() {
    }

    public TimeSheet(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "time_id", nullable = false)
    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }


    @Column(name = "hours_worked", nullable = true)
    public Integer getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Integer hoursWorked) {
        this.hoursWorked = hoursWorked;
    }


    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Staff getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(Staff staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSheet timesheet = (TimeSheet) o;

        if (timeId != timesheet.timeId) return false;
        if (hoursWorked != timesheet.hoursWorked) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = timeId;
        result = 31 * result + hoursWorked;
        return result;
    }

}
