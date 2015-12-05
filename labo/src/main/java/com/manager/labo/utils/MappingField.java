package com.manager.labo.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MappingsField.class)
@Target(ElementType.FIELD)
public @interface MappingField {

    /**
     * Name of the swing field to map. Name of the model field if not provided.
     */
    String value() default "";
}
