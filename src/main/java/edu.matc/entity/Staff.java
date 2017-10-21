package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addr_id", nullable=false)
    private Address address;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "staff", cascade = CascadeType.ALL)
    private Set<Client> clients = new HashSet<Client>();
    //private Set<Client> clients = new HashSet<Client>();

    public Staff() {
    }

    public Staff(String firstName, String lastName, LocalDate birthDt, String phoneNr, String email,
                  String payCd, String jobTitle) {
        //String payCd, String jobTitle, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDt = birthDt;
        this.phoneNr = phoneNr;
        this.email = email;
        this.payCd = payCd;
        this.jobTitle = jobTitle;
        //this.address = address;
    }



    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public LocalDate getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(LocalDate birthDt) {
        this.birthDt = birthDt;
    }


    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPayCd() {
        return payCd;
    }

    public void setPayCd(String payCd) {
        this.payCd = payCd;
    }


    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Set<Client> getClients() { return clients; }

    public void setClients(Set<Client> clients) { this.clients = clients; }



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
