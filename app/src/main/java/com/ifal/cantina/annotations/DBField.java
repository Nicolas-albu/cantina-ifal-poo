package com.ifal.cantina.annotations;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Indicates that a field represents a database column.
 * The annotation is used to specify the column name.
 *
 * @author Nicolas Albuquerque R.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DBField {
    /**
     * Specifies the name of the database column.
     */
    String fieldName();
}
