package edu.matc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "code")
public class Code {

    @Id
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "desc",  nullable = false)
    private String desc;

    public Code() {}

    public Code(String code, String value, String desc) {
        this.code = code;
        this.value = value;
        this.desc = desc;
    }

    public String getCode() { return code; }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
