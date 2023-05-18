package com.ifal.cantina.annotations;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <p> The Id annotation is used to mark a field as representing the identifier of an entity.</p>
 * <p> It can be applied to fields within a class to indicate that they correspond to the ID
 * attribute of the entity.</p>
 * <p> The annotation can be used at runtime and targets the FIELD element type.</p>
 * <p> It provides an optional parameter 'idName' that allows specifying a custom name for the
 * identifier. If no value is provided for 'idName', the default empty string is used.</p>
 * <p> <strong>Note:</strong> The presence of the Id annotation does not automatically imply any
 * behavior or functionality.</p>
 *
 * @author Nicolas Albuquerque R.
 * @see DBTable
 * @see DBField
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Id {
    String idName() default "";
}
