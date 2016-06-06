package com.hebut.mvc.webbasic;

/**
 * Created by jxy on 2016/6/6.
 */
public class NullParamException extends Exception{
    public NullParamException() {
    }

    public NullParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullParamException(Throwable cause) {

        super(cause);
    }

    public NullParamException(String message) {

        super(message);
    }
}
