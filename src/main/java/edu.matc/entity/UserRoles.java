package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * This class represents a UserRoles object.
 *
 * @author Pablo Cataggatan
 */
@Entity
@Table(name = "user_roles")
public class UserRoles {
    private int userRolesId;
    private String username;
    private String rolename;

    public UserRoles() {
    }


    public UserRoles(int userRolesId, String username, String rolename) {
        this.userRolesId = userRolesId;
        this.username = username;
        this.rolename = rolename;
    }

    /**
     * Gets the UserRoles' Id
     * @return the UserRoles' Id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "user_roles_id", nullable = false)
    public int getUserRolesId() {
        return userRolesId;
    }

    /**
     * Sets the UserRoles' Id
     * @param userRolesId  the value for the UserRoles' Id
     */
    public void setUserRolesId(int userRolesId) {
        this.userRolesId = userRolesId;
    }

    /**
     * Gets the UserRoles' username.
     * @return the UserRoles' username
     */
    @Basic
    @Column(name = "username", nullable = false, length = 15)
    public String getUsername() {
        return username;
    }

    /**
     * Sets the UserRoles' username.
     * @param username  the value for the UserRoles' username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the UserRoles' rolename.
     * @return the UserRoles' rolename
     */
    @Basic
    @Column(name = "rolename", nullable = false, length = 15)
    public String getRolename() {
        return rolename;
    }

    /**
     * Sets the UserRoles' rolename.
     * @param rolename  the value for the UserRoles' rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }


    /**
     * Compares the parameter object with this UserRoles class.
     * @param o Object to compare with this UserRoles class
     * @return true if object matches this class, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        if (userRolesId != userRoles.userRolesId) return false;
        if (username != null ? !username.equals(userRoles.username) : userRoles.username != null) return false;
        if (rolename != null ? !rolename.equals(userRoles.rolename) : userRoles.rolename != null) return false;

        return true;
    }


    /**
     * Generates hash code for this UserRoles class.
     * @return hash code for this UserRoles object
     */
    @Override
    public int hashCode() {
        int result = userRolesId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        return result;
    }
}
