package edu.nbut.project_manage.bean.dto;

import edu.nbut.project_manage.enums.DataDictionary;

import java.util.HashMap;
import java.util.Map;

public class ResultDTO {
    private Integer code;
    private String msg;

    private Map<String, Object> data;

    public ResultDTO() {
        this.data = new HashMap<String, Object>();
    }

    public ResultDTO(DataDictionary dataDictionary) {
        this.code = dataDictionary.getCode();
        this.msg = dataDictionary.getMsg();
        this.data = new HashMap<String, Object>();
    }

    public ResultDTO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = new HashMap<String, Object>();
    }

    public ResultDTO addData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public void setCodeAndMsg(DataDictionary dataDictionary) {
        this.code = dataDictionary.getCode();
        this.msg = dataDictionary.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
