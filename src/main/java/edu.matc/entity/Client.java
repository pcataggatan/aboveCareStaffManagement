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

    @Column(name = "phone_nr", nullable = false, length = 15)
    private String phoneNr;

    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Column(name = "bill_cd", nullable = false, length = 3)
    private String billCd;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addr_id", nullable=false)
    private Address address;


/*
    //@OneToMany(mappedBy = "staffByStaffId")
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "staffByStaffId", cascade = CascadeType.ALL))
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clientByClientId")
    private Set<Schedule> schedules = new HashSet<Schedule>();
*/

    public Client() {
    }

    public Client(String firstName, String lastName, LocalDate birthDt, String phoneNr, String email,
                  String billCd, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDt = birthDt;
        this.phoneNr = phoneNr;
        this.email = email;
        this.billCd = billCd;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public int getClientId() { return clientId; }

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (clientId != client.clientId) return false;
        if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
        if (lastName != null ? !lastName.equals(client.lastName) : client.lastName != null) return false;
        if (birthDt != null ? !birthDt.equals(client.birthDt) : client.birthDt != null) return false;
        if (phoneNr != null ? !phoneNr.equals(client.phoneNr) : client.phoneNr != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (billCd != null ? !billCd.equals(client.billCd) : client.billCd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDt != null ? birthDt.hashCode() : 0);
        result = 31 * result + (phoneNr != null ? phoneNr.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (billCd != null ? billCd.hashCode() : 0);
        return result;
    }
}
