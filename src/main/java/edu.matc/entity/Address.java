package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "addr_id", nullable = false)
    private int addrId;

    @Column(name = "street", nullable = false, length = 40)
    private String street;

    @Column(name = "city", nullable = false, length = 25)
    private String city;

    @Column(name = "state", nullable = false, length = 2)
    private String state;

    @Column(name = "zipcode", nullable = false, length = 5)
    private String zipcode;


    @OneToMany(mappedBy = "address")
    private Set<Client> clients;



    public Address() {
    }

    public Address(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }




    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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




    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (addrId != address.addrId) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (state != null ? !state.equals(address.state) : address.state != null) return false;
        if (zipcode != null ? !zipcode.equals(address.zipcode) : address.zipcode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addrId;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        return result;
    }
}
