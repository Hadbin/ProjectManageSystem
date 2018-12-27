package edu.nbut.project_manage.bean.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Role {
    private Integer roleId;
    private String title;                     //角色名称
    private String remarks;
    private List<Permission> permissions;       // 拥有的权限集合
    public Role() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

   public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", title='" + title + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
