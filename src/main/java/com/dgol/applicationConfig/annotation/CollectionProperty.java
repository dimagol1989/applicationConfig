package com.dgol.applicationConfig.annotation;

import com.dgol.applicationConfig.converters.Converter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;

/**
 * Annotation for properties that need to be stored in a {@link Collection}
 * Basically if the value is 1,2,3,4, one can store them in a {@link java.util.HashSet}
 * by this annotation
 *
 * @author dima.golomozy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CollectionProperty
{
    /**
     * @return true if need to update the key's value if the properties get changed
     */
    boolean putToUpdate() default false;

    /**
     * @return the delimiter to split the value with
     */
    String delimiter();

    /**
     * @return the {@link Converter} to use to convert the key's value
     */
    Class<? extends Converter<?>> converter();

    /**
     * @return the {@link Collection} class to create to store the converted values
     */
    Class<? extends Collection> collection();
}
