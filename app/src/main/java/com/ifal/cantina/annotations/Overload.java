package com.ifal.cantina.annotations;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <p> Indicates that a method or constructor is an overloaded version of another method or
 * constructor.</p>
 * <p> This annotation serves as a documentation to indicate the purpose of the method or
 * constructor.</p>
 *
 * @author Nicolas Albuquerque R.
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface Overload {
}
