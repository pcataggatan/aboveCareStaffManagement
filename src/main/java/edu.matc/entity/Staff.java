package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a Staff object.
 *
 * @author Pablo Cataggatan
 */
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "staff_id", nullable = false)
    private int staffId;

    @Column(name = "first_name", nullable = false, length = 25)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "birth_dt", nullable = false)
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate birthDt;

    @Column(name = "phone_nr", nullable = false, length = 15)
    private String phoneNr;

    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Column(name = "pay_cd", nullable = false, length = 3)
    private String payCd;

    @Column(name = "job_title", nullable = false, length = 20)
    private String jobTitle;

    @Column(name = "distance", nullable = true)
    private double distance;

    @Column(name = "hourly_rate", nullable = true, length = 6)
    private String hourlyRate;

    @Column(name = "schedule", nullable = true, length = 50)
    private String schedule;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addr_id", nullable=false)
    private Address address;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "staff", cascade = CascadeType.ALL)
    private Set<Client> clients = new HashSet<Client>();


    public Staff() {
    }

    public Staff(String firstName, String lastName, LocalDate birthDt, String phoneNr, String email,
                  String payCd, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDt = birthDt;
        this.phoneNr = phoneNr;
        this.email = email;
        this.payCd = payCd;
        this.jobTitle = jobTitle;
    }


    /**
     * Gets the Staff's Id.
     * @return the Staff's Id
     */
    public int getStaffId() {
        return staffId;
    }

    /**
     * Sets the Staff's Id.
     * @param staffId  the value for the Staff's Id
     */
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    /**
     * Gets the Staff's first name.
     * @return the Staff's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the Staff's first name.
     * @param firstName  the value for the Staff's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the Staff's last name.
     * @return the Staff's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the Staff's last name.
     * @param lastName the value for the Staff's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the Staff's birth date.
     * @return the Staff's birth date
     */
    public LocalDate getBirthDt() {
        return birthDt;
    }

    /**
     * Sets the Staff's birth date.
     * @param birthDt  the value for the Staff's birth date
     */
    public void setBirthDt(LocalDate birthDt) {
        this.birthDt = birthDt;
    }

    /**
     * Gets the Staff's phone number.
     * @return the Staff's phone number
     */
    public String getPhoneNr() {
        return phoneNr;
    }

    /**
     * Sets the Staff's phone number.
     * @param phoneNr  the value for the Staff's phone number
     */
    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    /**
     * Gets the Staff's email address.
     * @return the Staff's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the Staff's email address.
     * @param email  the value for the Staff's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the Staff's pay code.
     * @return the Staff's pay code
     */
    public String getPayCd() {
        return payCd;
    }

    /**
     * Sets the Staff's pay code.
     * @param payCd  the value for the Staff's pay code
     */
    public void setPayCd(String payCd) {
        this.payCd = payCd;
    }

    /**
     * Gets the Staff's job title.
     * @return the Staff's job title
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Sets the Staff's job title.
     * @param jobTitle  the value for the Staff's job title
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Gets the Staff's address.
     * @return the Staff's address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the Staff's address.
     * @param address  the value for the Staff's address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets the Clients for the Staff.
     * @return the Clients for the Staff
     */
    public Set<Client> getClients() { return clients; }

    /**
     * Sets the Clients for the Staff.
     * @param clients  the list of Clients for the Staff
     */
    public void setClients(Set<Client> clients) { this.clients = clients; }

    /**
     * Gets the distance of the Staff's address from Client's zipcode.
     * @return the distance of the Staff's address from Client's zipcode
     */
    public double getDistance() { return distance; }

    /**
     * Sets the distance of the Staff's address from Client's zipcode.
     * @param distance  the value for distance of the Staff's address from Client's zipcode
     */
    public void setDistance(double distance) { this.distance = distance; }

    /**
     * Gets the Staff's hourly rate.
     * @return the Staff's hourly rate
     */
    public String getHourlyRate() { return hourlyRate; }

    /**
     * Sets the Staff's hourly rate.
     * @param hourlyRate  the value for the Staff's hourly rate
     */
    public void setHourlyRate(String hourlyRate) { this.hourlyRate = hourlyRate; }

    /**
     * Gets the Staff's schedule.
     * @return the Staff's schedule
     */
    public String getSchedule() { return schedule; }

    /**
     * Sets the Staff's schedule.
     * @param schedule  the value for the Staff's schedule
     */
    public void setSchedule(String schedule) { this.schedule = schedule; }


    /**
     * Compares the parameter object with this Staff class.
     * @param o Object to compare with this Staff class
     * @return true if object matches this class, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (staffId != staff.staffId) return false;
        if (firstName != null ? !firstName.equals(staff.firstName) : staff.firstName != null) return false;
        if (lastName != null ? !lastName.equals(staff.lastName) : staff.lastName != null) return false;
        if (birthDt != null ? !birthDt.equals(staff.birthDt) : staff.birthDt != null) return false;
        if (phoneNr != null ? !phoneNr.equals(staff.phoneNr) : staff.phoneNr != null) return false;
        if (email != null ? !email.equals(staff.email) : staff.email != null) return false;
        if (payCd != null ? !payCd.equals(staff.payCd) : staff.payCd != null) return false;
        if (jobTitle != null ? !jobTitle.equals(staff.jobTitle) : staff.jobTitle != null) return false;

        return true;
    }


    /**
     * Generates hash code for this Staff class.
     * @return hash code for this Staff object
     */
    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDt != null ? birthDt.hashCode() : 0);
        result = 31 * result + (phoneNr != null ? phoneNr.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (payCd != null ? payCd.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        return result;
    }
}
