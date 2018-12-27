package edu.nbut.project_manage.bean.entity;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserInfo {
    private Integer userId;
    private String name;
    private Integer unitId;
    private String position;
    private String username;
    private String password;
    private String regDate;
    private Short status;
    private Integer userType;
    private String remarks;
    private List<Role> roles;       // 该用户拥有的角色
    private Unit unit;              //所属单位

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", unitId=" + unitId +
                ", position='" + position + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", regDate='" + regDate + '\'' +
                ", status=" + status +
                ", userType=" + userType +
                ", remarks='" + remarks + '\'' +
                ", roles=" + roles +
                ", unit=" + unit +
                '}';
    }
}
