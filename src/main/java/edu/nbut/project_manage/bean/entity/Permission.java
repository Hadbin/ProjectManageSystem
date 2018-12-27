package edu.nbut.project_manage.bean.entity;

import org.springframework.stereotype.Component;

@Component
public class Permission {
    private Integer permissionId;
    private String title;
    private Integer idx;
    private Integer parentId;
    private String url;
    private String remarks;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", title='" + title + '\'' +
                ", idx=" + idx +
                ", parentId=" + parentId +
                ", url='" + url + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
