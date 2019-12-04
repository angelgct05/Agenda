package com.agenda;

public @interface Author {
	String name();
	String createDate();
	String modifyDate() default "no";
	String lastChange() default "no";
	String version() default "0";
	String notes() default "no";
}
