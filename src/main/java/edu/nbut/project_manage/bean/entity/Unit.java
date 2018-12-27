package edu.nbut.project_manage.bean.entity;

public class Unit {
    private Integer unitId;
    private String title;           //单位名字
    private String address;         //地址
    private String legPerson;       //法人
    private String principal;       //负责人
    private String priPhone;        //负责人电话

    private String person1;         //联系人1
    private String phone1;          //联系人1电话
    private String position1;       //联系人1岗位
    private String person2;
    private String phone2;
    private String position2;
    private Integer streetId;          //所属街道
    private String regDate;         //注册日期
    private Integer industry;       //所属行业
    private String nature;          //企业性质
    private String productInfo;     //主要产品介绍
    private String companyInfo;     //企业介绍
    private String accountBank;     //基本户开户行
    private String accountNum;      //基本户账号
    private String creditCode;      //社会信用代码
    private String remarks;

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLegPerson() {
        return legPerson;
    }

    public void setLegPerson(String legPerson) {
        this.legPerson = legPerson;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPriPhone() {
        return priPhone;
    }

    public void setPriPhone(String priPhone) {
        this.priPhone = priPhone;
    }

    public String getPerson1() {
        return person1;
    }

    public void setPerson1(String person1) {
        this.person1 = person1;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPosition1() {
        return position1;
    }

    public void setPosition1(String position1) {
        this.position1 = position1;
    }

    public String getPerson2() {
        return person2;
    }

    public void setPerson2(String person2) {
        this.person2 = person2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPosition2() {
        return position2;
    }

    public void setPosition2(String position2) {
        this.position2 = position2;
    }

    public Integer getStreet() {
        return streetId;
    }

    public void setStreet(Integer streetId) {
        this.streetId = streetId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitId=" + unitId +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", legPerson='" + legPerson + '\'' +
                ", principal='" + principal + '\'' +
                ", priPhone='" + priPhone + '\'' +
                ", person1='" + person1 + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", position1='" + position1 + '\'' +
                ", person2='" + person2 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", position2='" + position2 + '\'' +
                ", streetId='" + streetId + '\'' +
                ", regDate='" + regDate + '\'' +
                ", industry=" + industry +
                ", nature='" + nature + '\'' +
                ", productInfo='" + productInfo + '\'' +
                ", companyInfo='" + companyInfo + '\'' +
                ", accountBank='" + accountBank + '\'' +
                ", accountNum='" + accountNum + '\'' +
                ", creditCode='" + creditCode + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
