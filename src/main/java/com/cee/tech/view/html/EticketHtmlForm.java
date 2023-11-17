package com.cee.tech.view.html;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EticketHtmlForm {
    String label() default "";
    String url() ;
    String httpMethod() default "POST";

}
