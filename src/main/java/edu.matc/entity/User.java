package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * This class represents a User object.
 *
 * @author Pablo Cataggatan
 */
@Entity
@Table (name = "user")
public class User {
    private int userId;
    private String username;
    private String password;
    private String rolename;
    private String email;

    public User() {
    }


    public User (int userId, String username, String password, String rolename, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.rolename = rolename;
        this.email = email;
    }


    /**
     * Gets the User's id.
     * @return the User's Id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the User's id.
     * @param userId  the value for the User's Id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the User's username.
     * @return the User's username
     */
    @Basic
    @Column(name = "username", nullable = false, length = 15)
    public String getUsername() {
        return username;
    }

    /**
     * Sets the User's username.
     * @param username  the value for the User's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the User's password.
     * @return the User's password
     */
    @Basic
    @Column(name = "password", nullable = false, length = 15)
    public String getPassword() {
        return password;
    }

    /**
     * Sets the User's password.
     * @param password  the value for the User's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the User's rolename.
     * @return the User's rolename
     */
    @Basic
    @Column(name = "rolename", nullable = false, length = 15)
    public String getRolename() {
        return rolename;
    }

    /**
     * Sets the User's rolename.
     * @param rolename  the vlue for the User's rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * Gets the User's email address.
     * @return the User's email address
     */
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    /**
     * Sets the User's email address.
     * @param email  the value for the User's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Compares the parameter object with this User class.
     * @param o Object to compare with this User class
     * @return true if object matches this class, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (rolename != null ? !rolename.equals(user.rolename) : user.rolename != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;

        return true;
    }

    /**
     * Generates hash code for this User class.
     * @return hash code for this User object
     */
    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
