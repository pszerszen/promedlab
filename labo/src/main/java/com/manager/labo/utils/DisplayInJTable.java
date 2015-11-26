package com.manager.labo.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.manager.labo.view.components.TableModelName;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(DisplaysInJTable.class)
@Target(ElementType.FIELD)
public @interface DisplayInJTable {

    /**
     * Name of the table model instance.
     *
     * @return name of table model;
     */
    TableModelName name();

    /**
     * Set number of column in JTable this field should be displayed.
     *
     * @return number of column (indexed from 0)
     */
    int order();
}
