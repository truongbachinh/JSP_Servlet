package model;

import java.sql.Date;

public class UserRole {
    private int roleId;
    private int userId;
    private Date date;

    public UserRole(int roleId, int userId, Date date) {
        this.roleId = roleId;
        this.userId = userId;
        this.date = date;
    }

    public UserRole(int roleId, int userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public UserRole() {

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
