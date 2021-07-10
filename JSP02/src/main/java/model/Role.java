package model;

import java.io.Serializable;

public class Role implements Serializable {
    private static final long serialVersionUID  = 1L;
    private int roleId;
    private String roleName;
    private String roleDes;

    public Role(String roleName, String roleDes) {
        this.roleName = roleName;
        this.roleDes = roleDes;
    }
    public Role() {
        this.roleName = "";
        this.roleDes = "";
    }

    public Role(int roleId, String roleName, String roleDes) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDes = roleDes;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDes() {
        return roleDes;
    }

    public void setRoleDes(String roleDes) {
        this.roleDes = roleDes;
    }
}
