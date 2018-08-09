package com.ljj.ssm.exception;

/**
 * @Auther: ljj
 * @Date: 2018/8/9 21:26
 * @Description:
 */
public class CustomException extends Exception{
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
