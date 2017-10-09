package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table (name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "assign_id", nullable = false)
    private int assignId;

    @Column(name = "staff_id", nullable = false)
    private int staffId;

    @Column(name = "client_id", nullable = false)
    private int clientId;

    // why staffId and clientID not included in the generated code ???
    // shouldn't we have List<Sched> here ???
    // this is 1:many  assigment:sched
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "assignment")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignment")
    private Set<Sched> scheds;


    public Assignment() {
    }


    public Assignment(int assignId, int staffId, int clientId) {
       this.assignId = assignId;
       this.staffId = staffId;
       this.clientId = clientId;
    }


    public int getAssignId() {
        return assignId;
    }

    public void setAssignId(int assignId) {
        this.assignId = assignId;
    }


    public int getStaffId() { return staffId; }

    public void setStaffId(int staffId) { this.staffId = staffId; }


    public int getClientId() { return clientId; }

    public void setClientId(int clientId) { this.clientId = clientId; }


    public Set<Sched> getScheds() {
        return this.scheds;
    }

    public void setScheds(Set<Sched> scheds) {
        this.scheds = scheds;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assignment assign = (Assignment) o;

        if (assignId != assign.assignId) return false;
        if (staffId != assign.staffId) return false;
        if (clientId != assign.clientId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = assignId;

        result = 31 * result + staffId;
        result = 31 * result + clientId;

        return result;
    }
}
