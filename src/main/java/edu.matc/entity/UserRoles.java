package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "user_roles_id", nullable = false)
    public int getUserRolesId() {
        return userRolesId;
    }

    public void setUserRolesId(int userRolesId) {
        this.userRolesId = userRolesId;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 15)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "rolename", nullable = false, length = 15)
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

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

    @Override
    public int hashCode() {
        int result = userRolesId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        return result;
    }
}
