package com.ifal.cantina.utils;

import com.ifal.cantina.annotations.Overload;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Utility class for handling user input.
 * Provides methods for handling string, integer, and double input.
 *
 * @author Nicolas Albuquerque R.
 */
public class HandleInput {
    private static final Scanner read = new Scanner(System.in);

    /**
     * Handles user input for a string value.
     *
     * @param question the prompt/question to display to the user.
     * @return the user input as a string.
     */
    public static String handleString(String question) {
        String output;

        while (true) {
            try {
                System.out.print(question);
                output = read.nextLine().trim();

                if (output.isEmpty()) throw new NoSuchElementException();
                break;

            } catch (NoSuchElementException error) {
                System.out.println(Utils.coloredExceptionMessage("%s%n",
                        ReadProperties.getProperty("error.show.expect-string")));
            }
        }

        return output;
    }


    /**
     * Handles user input for a non-empty string value.
     * It then trims the input to remove leading and trailing whitespace.
     *
     * @param question the prompt/question to display to the user.
     * @return the user input as a non-empty string.
     */
    public static String handleNonEmptyString(String question) {
        String output;

        while (true) {
            try {
                System.out.print(question);
                output = read.nextLine().trim();

                break;

            } catch (NoSuchElementException error) {
                System.out.println(Utils.coloredExceptionMessage("%s%n",
                        ReadProperties.getProperty("error.show.expect-string")));
            }
        }

        return output;
    }

    /**
     * Handles user input for an integer value.
     *
     * @param question the prompt/question to display to the user.
     * @return the user input as an integer.
     */
    @Overload
    public static int handleInteger(String question) {
        int output;

        while (true) {
            try {
                System.out.print(question);
                output = Integer.parseInt(read.nextLine().trim());

                if (output <= 0) throw new NumberFormatException();
                break;

            } catch (NumberFormatException error) {
                System.out.println(Utils.coloredExceptionMessage("%s%n",
                        ReadProperties.getProperty("error.show.expect-integer")));
            }
        }

        return output;
    }

    /**
     * Handles user input for an integer value within a specified range.
     *
     * @param question           the prompt/question to display to the user.
     * @param limitNumberOfInput the upper limit of the acceptable input range.
     * @return the user input as an integer within the specified range.
     */
    @Overload
    public static int handleInteger(String question, int limitNumberOfInput) {
        int output;

        while (true) {
            try {
                System.out.print(question);
                output = Integer.parseInt(read.nextLine().trim());

                if (output <= 0 || output > limitNumberOfInput) throw new NumberFormatException();
                break;

            } catch (NumberFormatException error) {
                System.out.println(Utils.coloredExceptionMessage("%s%n",
                        ReadProperties.getProperty("error.show.expect-integer")));
            }
        }

        return output;
    }

    /**
     * Handles user input for a double value.
     *
     * @param question the prompt/question to display to the user.
     * @return the user input as a double.
     */
    public static double handleDouble(String question) {
        double output;

        while (true) {
            try {
                System.out.print(question);
                output = Double.parseDouble(read.nextLine().trim());

                if (output <= 0) throw new NumberFormatException();
                break;

            } catch (NumberFormatException error) {
                System.out.println(Utils.coloredExceptionMessage("%s%n",
                        ReadProperties.getProperty("error.show.expect-double")));
            }
        }

        return output;
    }
}
