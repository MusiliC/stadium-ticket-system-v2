package com.cee.tech.view.html;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EticketHtmlCard {
    String cssClass() default "";
    String pTag() default "";
    String label() default "";

}
