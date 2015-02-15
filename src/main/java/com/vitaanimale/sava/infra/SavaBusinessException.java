package com.vitaanimale.sava.infra;

/**
 *
 * @author Elisa
 */
public class SavaBusinessException extends Exception{
    public SavaBusinessException() {}

    public SavaBusinessException(String message) {
        super(message);
    }

    public SavaBusinessException(Throwable cause) {
        super(cause);
    }

    public SavaBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
