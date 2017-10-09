package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "code")
public class Code {
    private int codeId;
    private String code;
    private String value;
    private String descTx;

    public Code () {
    }

    public Code (int codeId, String code, String value, String descTx) {
        this.codeId = codeId;
        this.code = code;
        this.value = value;
        this.descTx = descTx;
    }


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "code_id", nullable = false)
    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 3)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "value", nullable = false, length = 5)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "desc_tx", nullable = false, length = 30)
    public String getDescTx() {
        return descTx;
    }

    public void setDescTx(String descTx) {
        this.descTx = descTx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Code code1 = (Code) o;

        if (codeId != code1.codeId) return false;
        if (code != null ? !code.equals(code1.code) : code1.code != null) return false;
        if (value != null ? !value.equals(code1.value) : code1.value != null) return false;
        if (descTx != null ? !descTx.equals(code1.descTx) : code1.descTx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeId;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (descTx != null ? descTx.hashCode() : 0);
        return result;
    }
}
