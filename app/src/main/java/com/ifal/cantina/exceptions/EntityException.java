package com.ifal.cantina.exceptions;

/**
 * Exception class representing an error related to entities in the application.
 * It is used to handle exceptional conditions that occur during entity operations.
 * This exception provides a custom detail message.
 *
 * @author Nicolas Albuquerque R.
 */
public class EntityException extends Exception {
    private String detailMessage = null;

    /**
     * Constructs a new EntityException with the specified detail message.
     *
     * @param detailMessage the detail message that describes the exception.
     */
    public EntityException(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    /**
     * Returns the detail message of this exception.
     *
     * @return the detail message as a string.
     */
    public String getMessage() {
        return this.detailMessage;
    }
}
