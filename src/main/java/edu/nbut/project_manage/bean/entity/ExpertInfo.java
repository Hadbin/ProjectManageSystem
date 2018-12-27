package edu.nbut.project_manage.bean.entity;

public class ExpertInfo {
    private Integer expertInfoId;

    private String name;

    private String gender;

    private String birth;           //出生年月

    private String political;       //政治面貌

    private String title;           //职称

    private String assTime;         //评定时间

    private String idNum;           //身份证号码

    private String picture;         //照片

    private String phone1;          //联系电话1

    private String phone2;          //联系电话2

    private String email;           //电子邮箱

    private Short education;        //学历(字典)

    private Short degree;           //学位(字典)

    private String school;          //毕业学校

    private String workUnit;        //工作单位

    private String unitAddress;     //单位地址

    private Integer profesDirectId;       //专业方向

    private Integer FamIndustryId;       //熟知行业

    private String experience;

    private String rewards;

    private String remarks;

    public Integer getExpertInfoId() {
        return expertInfoId;
    }

    public void setExpertInfoId(Integer expertInfoId) {
        this.expertInfoId = expertInfoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssTime() {
        return assTime;
    }

    public void setAssTime(String assTime) {
        this.assTime = assTime;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getEducation() {
        return education;
    }

    public void setEducation(Short education) {
        this.education = education;
    }

    public Short getDegree() {
        return degree;
    }

    public void setDegree(Short degree) {
        this.degree = degree;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public Integer getProfesDirectId() {
        return profesDirectId;
    }

    public void setProfesDirectId(Integer profesDirectId) {
        this.profesDirectId = profesDirectId;
    }

    public Integer getFamIndustryId() {
        return FamIndustryId;
    }

    public void setFamIndustryId(Integer famIndustryId) {
        FamIndustryId = famIndustryId;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    @Override
    public String toString() {
        return "ExpertInfo{" +
                "expertInfoId=" + expertInfoId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth + '\'' +
                ", political='" + political + '\'' +
                ", title='" + title + '\'' +
                ", assTime='" + assTime + '\'' +
                ", idNum='" + idNum + '\'' +
                ", picture='" + picture + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", email='" + email + '\'' +
                ", education=" + education +
                ", degree=" + degree +
                ", school='" + school + '\'' +
                ", workUnit='" + workUnit + '\'' +
                ", unitAddress='" + unitAddress + '\'' +
                ", profesDirectId=" + profesDirectId +
                ", FamIndustryId=" + FamIndustryId +
                ", experience='" + experience + '\'' +
                ", rewards='" + rewards + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}