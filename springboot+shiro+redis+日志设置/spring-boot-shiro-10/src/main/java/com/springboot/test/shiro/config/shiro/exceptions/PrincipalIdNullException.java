package com.springboot.test.shiro.config.shiro.exceptions;

/**
 * @author: Farben
 * @description: PrincipalIdNullException
 * @create: 2019/8/29-14:23
 **/
public class PrincipalIdNullException extends RuntimeException  {

    private static final String MESSAGE = "Principal Id shouldn't be null!";

    public PrincipalIdNullException(Class clazz, String idMethodName) {
        super(clazz + " id field: " +  idMethodName + ", value is null\n" + MESSAGE);
    }
}
