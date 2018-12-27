package edu.nbut.project_manage.bean.entity;

import org.springframework.stereotype.Component;

@Component
public class DicType {
    private Integer dicTypeId;
    private String title;
    private String remarks;

    public Integer getDicTypeId() {
        return dicTypeId;
    }

    public void setDicTypeId(Integer dicTypeId) {
        this.dicTypeId = dicTypeId;
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

    @Override
    public String toString() {
        return "DicType{" +
                "dicTypeId=" + dicTypeId +
                ", title='" + title + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
