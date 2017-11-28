package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class represents an Address object.
 *
 * @author: Pablo Cataggatan
 */
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


    public Address() {
    }

    public Address(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    /**
     * Gets the Address Id.
     * @return the Address id
     */
    public int getAddrId() { return addrId; }

    /**
     * Sets the Address Id.
     * @param addrId the value for the Address Id
     */
    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }


    /**
     * Gets the Street name.
     * @return the Street name
     */
    public String getStreet() {
        return street;
    }


    /**
     * Sets the Street name.
     * @param street the value for the Street
     */
    public void setStreet(String street) {
        this.street = street;
    }


    /**
     * Gets the City name.
     * @return the City name
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the City name.
     * @param city the value for the City
     */
    public void setCity(String city) {
        this.city = city;
    }


    /**
     * Gets the State code.
     * @return the State code
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the State name.
     * @param state the value for the State
     */
    public void setState(String state) {
        this.state = state;
    }


    /**
     * Gets the adress zipcode.
     * @return the address zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Sets the address zipcode.
     * @param zipcode the value for the address zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    /**
     * Compares the parameter object with this Address class.
     * @param o Object to compare with this Address class
     * @return true if object matches this class, else false
     */
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

    /**
     * Generates hash code for this Address class.
     * @return hash code for this Address object
     */
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
