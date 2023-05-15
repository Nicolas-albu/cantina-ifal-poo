package com.ifal.cantina.interfaces;

import com.ifal.cantina.utils.factorys.ResultMessageFactory;
import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.utils.Utils;

import java.util.Scanner;

/**
 * Represents a view in the application.
 * Provides a common interface for displaying information and interacting with the user.
 *
 * @author Nicolas Albuquerque R.
 * @see AController
 * @see AModel
 */
public abstract class AView {
    protected Scanner read;

    /**
     * Constructs a new instance of the AView class.
     * Initializes the Scanner for user input.
     */
    public AView() {
        this.read = new Scanner(System.in);
    }

    /**
     * Displays the view and handles user interaction.
     *
     * @return an object representing the result of the user interaction.
     */
    public abstract Object show() throws EntityException;

    /**
     * Prints the message of an exception.
     *
     * @param exception the exception to be printed.
     */
    public void printException(Exception exception) {
        System.out.println(Utils.coloredResultMessage(exception.getMessage()));
    }

    /**
     * Prints the result message to the console.
     */
    public void printResult() {
        String resultMessage = ResultMessageFactory.getResultMessage(this);

        System.out.println(Utils.coloredResultMessage(resultMessage));
    }

    /**
     * Closes the associated resource.
     * In this case, it closes the Scanner object used for input reading.
     */
    public void close() {
        this.read.close();
    }
}
