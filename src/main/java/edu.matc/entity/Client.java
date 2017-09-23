package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "client_id")
    private int clientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate brithDate;

    @Column(name = "st_addr1")
    private String addrLine1;

    @Column(name = "st_addr2")
    private String addrLine2;

    private String city;

    private String state;

    @Column(name = "zipcode")
    private String zipCd;

    @Column(name = "phone_nr")
    private String phoneNr;

    private String email;

    @Column(name = "rate_cd")
    private String rateCd;

    @Column(name = "eff_dt")
    private LocalDate effDt;

    @Column(name = "end_dt")
    private LocalDate endDt;

    public Client() {
    }

    public Client(int clientId, String firstName, String lastName, LocalDate brithDate,
                  String addrLine1, String addrLine2, String city, String state, String zipCd,
                  String phoneNr, String email, String rateCd, LocalDate effDt, LocalDate endDt) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.brithDate = brithDate;
        this.addrLine1 = addrLine1;
        this.addrLine2 = addrLine2;
        this.city = city;
        this.state = state;
        this.zipCd = zipCd;
        this.phoneNr = phoneNr;
        this.email = email;
        this.rateCd = rateCd;
        this.effDt = effDt;
        this.endDt = endDt;
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

    public LocalDate getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(LocalDate brithDate) {
        this.brithDate = brithDate;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
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

    public String getZipCd() {
        return zipCd;
    }

    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
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

    public String getRateCd() {
        return rateCd;
    }

    public void setRateCd(String rateCd) {
        this.rateCd = rateCd;
    }

    public LocalDate getEffDt() {
        return effDt;
    }

    public void setEffDt(LocalDate effDt) {
        this.effDt = effDt;
    }

    public LocalDate getEndDt() {
        return endDt;
    }

    public void setEndDt(LocalDate endDt) {
        this.endDt = endDt;
    }
}
