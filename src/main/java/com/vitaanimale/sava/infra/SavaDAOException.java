package com.vitaanimale.sava.infra;

/**
 *
 * @author Elisa
 */
public class SavaDAOException extends Exception {

    public SavaDAOException() {}

    public SavaDAOException(String message) {
        super(message);
    }

    public SavaDAOException(Throwable cause) {
        super(cause);
    }

    public SavaDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
