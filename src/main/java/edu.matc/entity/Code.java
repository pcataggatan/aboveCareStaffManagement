package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "code")
public class Code {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "client_id")
    private int codeId;

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
