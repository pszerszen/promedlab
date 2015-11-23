package com.manager.labo.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Piotr on 2015-11-23.
 */
@Entity
@Table(name = "icd")
public class Icd extends AbstractEntity {

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
}
