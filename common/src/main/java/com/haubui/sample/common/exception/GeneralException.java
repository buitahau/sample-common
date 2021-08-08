package com.haubui.sample.common.exception;

public class GeneralException extends Exception {

    public GeneralException() {
    }

    public GeneralException(String msg) {
        super(msg);
    }

    public GeneralException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public GeneralException(Throwable throwable) {
        super(throwable);
    }
}
