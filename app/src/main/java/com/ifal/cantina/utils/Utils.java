package com.ifal.cantina.utils;

import com.ifal.cantina.annotations.Overload;

import java.util.List;

/**
 * The Utils class provides various utility methods for common operations.
 * It includes methods for coloring exception messages.
 * And checking if a string contains only integers.
 *
 * @author Nicolas Albuquerque R.
 */
public class Utils {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static StringBuilder queryColumnNameAndValue;

    /**
     * Returns a colored exception message.
     * By adding red color formatting to the provided exception message.
     *
     * @param exceptionMessage The exception message to be colored.
     * @return The colored exception message.
     */
    @Overload
    public static String coloredExceptionMessage(String exceptionMessage) {
        return ANSI_RED + exceptionMessage + ANSI_RESET;
    }

    /**
     * Returns a colored exception message.
     * By adding red color formatting to the provided exception message.
     * After formatting it with the given arguments.
     *
     * @param exceptionMessage The exception message to be colored and formatted.
     * @param args             The arguments to be inserted into the formatted exception message.
     * @return The colored and formatted exception message.
     */
    @Overload
    public static String coloredExceptionMessage(String exceptionMessage, Object... args) {
        exceptionMessage = String.format(exceptionMessage, args);

        return ANSI_RED + exceptionMessage + ANSI_RESET;
    }

    /**
     * Formats the result message with colored text.
     *
     * @param resultMessage the result message to be colored.
     * @return the result message with colored text.
     */
    public static String coloredResultMessage(String resultMessage) {
        return ANSI_GREEN + resultMessage + ANSI_RESET;
    }

    /**
     * Checks if a given string contains only integer digits.
     *
     * @param input The string to be checked.
     * @return {@code true} if the string contains only integer digits, {@code false} otherwise.
     */
    public static boolean containsOnlyInteger(String input) {
        return input.matches("\\d+");
    }

    public static void saveQueryFormat(String columnValue, List<String> columnNames) {
        queryColumnNameAndValue = new StringBuilder();

        for (String columnName : columnNames) {
            if (!queryColumnNameAndValue.toString().equals("")) queryColumnNameAndValue.append(" | ");
            if (columnValue.equals("")) columnValue = "NULL";

            queryColumnNameAndValue.append(String.format("[%s] %s", columnName, columnValue));
        }
    }

    public static String getFormattedQuery() {
        return queryColumnNameAndValue.toString();
    }
}
