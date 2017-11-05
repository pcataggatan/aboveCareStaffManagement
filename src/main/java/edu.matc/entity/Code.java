package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "code")
public class Code {
    private String codeCode;
    private String codeValue;
    private String descTx;

    public Code () {
    }

    public Code (String code, String value, String desc) {
        this.codeCode = code;
        this.codeValue = value;
        this.descTx = descTx;
    }


    @Id
    @Column(name = "code", nullable = false, length = 3)
    public String getCode() {
        return codeCode;
    }

    public void setCode(String code) {
        this.codeCode = code;
    }


    @Column(name = "value", nullable = false, length = 6)
    public String getValue() {
        return codeValue;
    }

    public void setValue(String value) {
        this.codeValue = value;
    }


    @Column(name = "desc_tx", nullable = false, length = 40)
    public String getDescTx() {
        return descTx;
    }

    public void setDescTx(String desc) {
        this.descTx = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Code code1 = (Code) o;

        if (codeCode != null ? !codeCode.equals(code1.codeCode) : code1.codeCode != null) return false;
        if (codeValue != null ? !codeValue.equals(code1.codeValue) : code1.codeValue != null) return false;
        if (descTx != null ? !descTx.equals(code1.descTx) : code1.descTx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (codeCode != null ? codeCode.hashCode() : 0);
        result = 31 * result + (codeValue != null ? codeValue.hashCode() : 0);
        result = 31 * result + (descTx != null ? descTx.hashCode() : 0);
        return result;
    }
}
