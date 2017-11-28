package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * This class represents a Code object.
 *
 * @author: Pablo Cataggatan
 */
@Entity
@Table(name = "code")
public class Code {
    private String codeCode;
    private String codeValue;
    private String descTx;

    public Code () {
    }

    public Code (String code, String value, String descTx) {
        this.codeCode = code;
        this.codeValue = value;
        this.descTx = descTx;
    }


    /**
     * Gets the code.
     * @return the code
     */
    @Id
    @Column(name = "code", nullable = false, length = 3)
    public String getCodeCode() {
        return codeCode;
    }

    /**
     * Sets the code.
     * @return the value for the code
     */
    public void setCodeCode(String code) {
        this.codeCode = code;
    }

    /**
     * Gets the code's value.
     * @return the code's value
     */
    @Column(name = "value", nullable = false, length = 6)
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * Sets the code's value.
     * @return the value for the code's value
     */
    public void setCodeValue(String value) {
        this.codeValue = value;
    }


    /**
     * Gets the code's description.
     * @return the code's description
     */
    @Column(name = "desc_tx", nullable = false, length = 40)
    public String getDescTx() {
        return descTx;
    }

    /**
     * Sets the code's description.
     * @return the value for the code's description
     */
    public void setDescTx(String desc) {
        this.descTx = desc;
    }

    /**
     * Compares the parameter object with this Code class.
     * @param o Object to compare with this Code class
     * @return true if object matches this class, else false
     */
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

    /**
     * Generates hash code for this Code class.
     * @return hash code for this Code object
     */
    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (codeCode != null ? codeCode.hashCode() : 0);
        result = 31 * result + (codeValue != null ? codeValue.hashCode() : 0);
        result = 31 * result + (descTx != null ? descTx.hashCode() : 0);
        return result;
    }
}