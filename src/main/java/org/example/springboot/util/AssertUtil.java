package org.example.springboot.util;

import org.example.springboot.exception.ParamsException;

public class AssertUtil {
    public static void isTrue(boolean flag, String msg){
        if (flag){
            throw new ParamsException(msg);
        }
    }
}
