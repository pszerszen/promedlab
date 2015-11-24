package com.manager.labo.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A basic entity type containing an id field. Every entity should extend this type.
 *
 * @author Piotr
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 3137727858942906410L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
