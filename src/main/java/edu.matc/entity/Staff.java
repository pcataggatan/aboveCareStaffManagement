package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "staff")
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

    @Column(name = "st_addr1", nullable = false, length = 40)
    private String stAddr1;

    @Column(name = "st_addr2", nullable = true, length = 40)
    private String stAddr2;

    @Column(name = "city", nullable = false, length = 25)
    private String city;

    @Column(name = "state", nullable = false, length = 2)    private String state;

    @Column(name = "zipcode", nullable = false, length = 5)
    private String zipcode;

    @Column(name = "phone_nr", nullable = false, length = 15)
    private String phoneNr;

    @Column(name = "email", nullable = true, length = 50)    private String email;

    @Column(name = "pay_cd", nullable = false, length = 3)
    private String payCd;

    @Column(name = "hours_worked", nullable = false)
    private int hoursWorked;



    @OneToMany(mappedBy="staff")
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setEmployees(List<Client> clients) {
        this.clients = clients;
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

    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(LocalDate birthDt) { this.birthDt = birthDt; }

    public String getStAddr1() {
        return stAddr1;
    }

    public void setStAddr1(String stAddr1) {
        this.stAddr1 = stAddr1;
    }

    public String getStAddr2() {
        return stAddr2;
    }

    public void setStAddr2(String stAddr2) {
        this.stAddr2 = stAddr2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    public int getHoursWorked() { return hoursWorked; }

    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (staffId != staff.staffId) return false;
        if (firstName != null ? !firstName.equals(staff.firstName) : staff.firstName != null) return false;
        if (lastName != null ? !lastName.equals(staff.lastName) : staff.lastName != null) return false;
        if (birthDt != null ? !birthDt.equals(staff.birthDt) : staff.birthDt != null) return false;
        if (stAddr1 != null ? !stAddr1.equals(staff.stAddr1) : staff.stAddr1 != null) return false;
        if (stAddr2 != null ? !stAddr2.equals(staff.stAddr2) : staff.stAddr2 != null) return false;
        if (city != null ? !city.equals(staff.city) : staff.city != null) return false;
        if (state != null ? !state.equals(staff.state) : staff.state != null) return false;
        if (zipcode != null ? !zipcode.equals(staff.zipcode) : staff.zipcode != null) return false;
        if (phoneNr != null ? !phoneNr.equals(staff.phoneNr) : staff.phoneNr != null) return false;
        if (email != null ? !email.equals(staff.email) : staff.email != null) return false;
        if (payCd != null ? !payCd.equals(staff.payCd) : staff.payCd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDt != null ? birthDt.hashCode() : 0);
        result = 31 * result + (stAddr1 != null ? stAddr1.hashCode() : 0);
        result = 31 * result + (stAddr2 != null ? stAddr2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (phoneNr != null ? phoneNr.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (payCd != null ? payCd.hashCode() : 0);
        return result;
    }
}
