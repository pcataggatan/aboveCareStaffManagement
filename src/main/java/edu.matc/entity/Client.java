package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * This class represents a Client object.
 *
 * @author: Pablo Cataggatan
 */
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

    @Column(name = "hourly_rate", nullable = true)
    private String hourlyRate;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addr_id", nullable=false)
    private Address address;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staff_id")
    private Staff staff;


    public Client() {
    }

    public Client(String firstName, String lastName, LocalDate birthDt, String phoneNr, String email,
                  String billCd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDt = birthDt;
        this.phoneNr = phoneNr;
        this.email = email;
        this.billCd = billCd;
    }


    /**
     * Gets the Client's Id.
     * @return the Client's Id
     */
    public int getClientId() { return clientId; }

    /**
     * Sets the Client's Id.
     * @param clientId the value for the Client's Id
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }


    /**
     * Gets the Client's first name.
     * @return the Client's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the Client's first name.
     * @param firstName the value for the Client's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the Client's last name.
     * @return the Client's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the Client's last name.
     * @param lastName the value for the Client's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the Client's birth date.
     * @return the Client's birth date
     */
    public LocalDate getBirthDt() {
        return birthDt;
    }

    /**
     * Sets the Client's birth date.
     * @param birthDt the value for the Client's birth date
     */
    public void setBirthDt(LocalDate birthDt) {
        this.birthDt = birthDt;
    }


    /**
     * Gets the Client's phone number.
     * @return the Client's phone number
     */
    public String getPhoneNr() {
        return phoneNr;
    }

    /**
     * Sets the Client's phone number.
     * @param phoneNr the value for the Client's phone number
     */
    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }


    /**
     * Gets the Client's email address.
     * @return the Client's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the Client's email address.
     * @param email the value for the Client's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the Client's bill code.
     * @return the Client's bill code
     */
    public String getBillCd() {
        return billCd;
    }

    /**
     * Sets the Client's bill code.
     * @param billCd the value for the Client's bill code
     */
    public void setBillCd(String billCd) {
        this.billCd = billCd;
    }

    /**
     * Gets the Client's hourly rate.
     * @return the Client's hourly rate.
     */
    public String getHourlyRate() { return hourlyRate; }

    /**
     * Sets the Client's hourly rate.
     * @param hourlyRate the value for the Client's hourly rate
     */
    public void setHourlyRate(String hourlyRate) { this.hourlyRate = hourlyRate; }


    /**
     * Gets the Client's address.
     * @return the Client's address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the Client's address.
     * @param address the value for the Client's address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets the Staff assigned to the Client.
     * @return the Staff for the Client
     */
    public Staff getStaff() { return staff; }

    /**
     * Sets the Staff for the Client.
     * @return the Staff for the Client
     */
    public void setStaff(Staff staff) { this.staff = staff; }


    /**
     * Compares the parameter object with this Client class.
     * @param o Object to compare with this Client class
     * @return true if object matches this class, else false
     */
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

    /**
     * Generates hash code for this Client class.
     * @return hash code for this Client object
     */
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
