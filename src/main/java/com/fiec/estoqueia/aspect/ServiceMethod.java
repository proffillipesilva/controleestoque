package com.fiec.estoqueia.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // This annotation can only be applied to methods
@Retention(RetentionPolicy.RUNTIME) // The annotation will be available at runtime
public @interface ServiceMethod {

    String value() default ""; // Optional description for the log message
}