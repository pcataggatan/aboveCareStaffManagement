package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    private int schedId;
    private String timeDays;
    private Client clientByClientId;
    private Staff staffByStaffId;


    public Schedule() {
    }

    public Schedule(String timeDays, Client clientByClientId, Staff staffByStaffId) {
        this.timeDays = timeDays;
        this.clientByClientId = clientByClientId;
        this.staffByStaffId = staffByStaffId;
    }



    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "sched_id", nullable = false)
    public int getSchedId() {
        return schedId;
    }

    public void setSchedId(int schedId) {
        this.schedId = schedId;
    }


    @Column(name = "time_days", nullable = true, length = 60)
    public String getTimeDays() {
        return timeDays;
    }

    public void setTimeDays(String timeDays) {
        this.timeDays = timeDays;
    }


    //@ManyToOne
    //@JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable=false)
    public Staff getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(Staff staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }


    //@ManyToOne
    //@JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", nullable=false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (schedId != schedule.schedId) return false;
        if (timeDays != null ? !timeDays.equals(schedule.timeDays) : schedule.timeDays != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedId;
        result = 31 * result + (timeDays != null ? timeDays.hashCode() : 0);
        return result;
    }

}
