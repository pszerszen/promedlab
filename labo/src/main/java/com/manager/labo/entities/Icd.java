package com.manager.labo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Piotr
 */
@Entity
@Table(name = "icd")
public class Icd extends AbstractEntity {

    private static final long serialVersionUID = 737118698885140108L;

    @Column(name = "code1", columnDefinition = "varchar(1)", nullable = false)
    private String code1;

    @Column(name = "name1", columnDefinition = "varchar(200)", nullable = false)
    private String name1;

    @Column(name = "code2", columnDefinition = "varchar(3)", nullable = false)
    private String code2;

    @Column(name = "name2", columnDefinition = "longtext", nullable = false)
    private String name2;

    public String getCode1() {
        return code1;
    }

    public void setCode1(final String code1) {
        this.code1 = code1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(final String name1) {
        this.name1 = name1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(final String code2) {
        this.code2 = code2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(final String name2) {
        this.name2 = name2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(code1)
                .append(name1)
                .append(code2)
                .append(name2)
                .build();
    }
    
    
}
