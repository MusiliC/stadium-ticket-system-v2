package com.cee.tech.database.helper;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DbTableColumn {
    String name();
    String definition() default "varchar(255)" ;
    String primaryKey() default "";
    String foreignKeyColumn() default "";
    String notNull() default "";


}
