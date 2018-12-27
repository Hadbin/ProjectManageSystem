package edu.nbut.project_manage.bean.entity;

import org.springframework.stereotype.Component;

@Component
public class DicItem {
    private Integer dicItemId;
    private String title;
    private String code;
    private Integer dicTypeId;
    private String remarks;

    public Integer getDicItemId() {
        return dicItemId;
    }

    public void setDicItemId(Integer dicItemId) {
        this.dicItemId = dicItemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDicTypeId() {
        return dicTypeId;
    }

    public void setDicTypeId(Integer dicTypeId) {
        this.dicTypeId = dicTypeId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "DicItem{" +
                "dicItemId=" + dicItemId +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", dicTypeId=" + dicTypeId +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
