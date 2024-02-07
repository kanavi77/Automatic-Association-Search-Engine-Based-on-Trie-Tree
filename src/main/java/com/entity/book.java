package com.entity;
import lombok.Data;

@Data
public class book {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    private String value;
    private Integer count;
    public String getValue() {
        return value;
    }

}
