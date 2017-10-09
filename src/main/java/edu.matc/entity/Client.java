package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "client_id", nullable = false)
    private int clientId;

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

    @Column(name = "state", nullable = false, length = 2)
    private String state;

    @Column(name = "zipcode", nullable = false, length = 5)
    private String zipcode;

    @Column(name = "phone_nr", nullable = false, length = 15)
    private String phoneNr;

    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Column(name = "bill_cd", nullable = false, length = 3)
    private String billCd;

    @Column(name = "sched1", nullable = true, length = 25)
    private String sched1;

    @Column(name = "sched2", nullable = true, length = 25)
    private String sched2;

    @Column(name = "sched3", nullable = true, length = 25)
    private String sched3;

    @ManyToOne
    @JoinColumn(name="staff_id")
    private Staff staff;


    public Client() {
    }

    public Client(String firstName, String lastName, LocalDate birthDt, String stAddr1, String stAddr2,
                  String city, String state, String zipcode, String phoneNr, String email,
                  String billCd, String sched1, String sched2, String sched3) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDt = birthDt;
        this.stAddr1 = stAddr1;
        this.stAddr2 = stAddr2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNr = phoneNr;
        this.email = email;
        this.billCd = billCd;
        this.sched1 = sched1;
        this.sched2 = sched2;
        this.sched3 = sched3;
    }


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public String getStAddr1() {
        return stAddr1;
    }

    public void setStAddr1(String stAddr1) { this.stAddr1 = stAddr1; }

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

    public String getBillCd() {
        return billCd;
    }

    public void setBillCd(String billCd) {
        this.billCd = billCd;
    }

    public String getSched1() {
        return sched1;
    }

    public void setSched1(String sched1) {
        this.sched1 = sched1;
    }

    public String getSched2() {
        return sched2;
    }

    public void setSched2(String sched2) {
        this.sched2 = sched2;
    }

    public String getSched3() {
        return sched3;
    }

    public void setSched3(String sched3) {
        this.sched3 = sched3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (clientId != client.clientId) return false;
        if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
        if (lastName != null ? !lastName.equals(client.lastName) : client.lastName != null) return false;
        if (birthDt != null ? !birthDt.equals(client.birthDt) : client.birthDt != null) return false;
        if (stAddr1 != null ? !stAddr1.equals(client.stAddr1) : client.stAddr1 != null) return false;
        if (stAddr2 != null ? !stAddr2.equals(client.stAddr2) : client.stAddr2 != null) return false;
        if (city != null ? !city.equals(client.city) : client.city != null) return false;
        if (state != null ? !state.equals(client.state) : client.state != null) return false;
        if (zipcode != null ? !zipcode.equals(client.zipcode) : client.zipcode != null) return false;
        if (phoneNr != null ? !phoneNr.equals(client.phoneNr) : client.phoneNr != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (billCd != null ? !billCd.equals(client.billCd) : client.billCd != null) return false;
        if (sched1 != null ? !sched1.equals(client.sched1) : client.sched1 != null) return false;
        if (sched2 != null ? !sched2.equals(client.sched2) : client.sched2 != null) return false;
        if (sched3 != null ? !sched3.equals(client.sched3) : client.sched3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
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
        result = 31 * result + (billCd != null ? billCd.hashCode() : 0);
        result = 31 * result + (sched1 != null ? sched1.hashCode() : 0);
        result = 31 * result + (sched2 != null ? sched2.hashCode() : 0);
        result = 31 * result + (sched3 != null ? sched3.hashCode() : 0);
        return result;
    }
}
