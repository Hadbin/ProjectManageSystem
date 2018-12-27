package edu.nbut.project_manage.bean.entity;

import java.util.List;

public class RolePermission {
    private Integer RolePermissionId;
    private Integer RoleId;
    private Integer PermissionId;

    public Integer getRolePermissionId() {
        return RolePermissionId;
    }

    public void setRolePermissionId(Integer rolePermissionId) {
        RolePermissionId = rolePermissionId;
    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer roleId) {
        RoleId = roleId;
    }

    public Integer getPermissionId() {
        return PermissionId;
    }

    public void setPermissionId(Integer permissionId) {
        PermissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "RolePermissionId=" + RolePermissionId +
                ", RoleId=" + RoleId +
                ", PermissionId=" + PermissionId +
                ", id=" + id +
                ", text='" + text + '\'' +
                ", children=" + children +
                ", checked=" + checked +
                ", c=" + c +
                '}';
    }

    ///以下代码还不是非常的明确
    private int id;
    private String text;
    private List<RolePermission> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<RolePermission> getChildren() {
        return children;
    }

    public void setChildren(List<RolePermission> children) {
        this.children = children;
    }

    private Boolean checked;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    private int c;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

}
