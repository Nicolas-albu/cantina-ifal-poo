package com.ifal.cantina.utils;

import com.ifal.cantina.annotations.Overload;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class HandleInput {
    private static final Scanner read = new Scanner(System.in);

    public static String handleString(String question) {
        String output;

        while (true) {
            try {
                System.out.print(question);
                output = read.nextLine().trim();

                if (output.isEmpty())
                    throw new NoSuchElementException();
                break;

            } catch (NoSuchElementException error) {
                System.out.printf("%s\n%n", ReadProperties.getProperty("error.show.expect-string"));
            }
        }

        return output;
    }

    @Overload
    public static int handleInteger(String question) {
        int output;

        while (true) {
            try {
                System.out.print(question);
                output = Integer.parseInt(read.nextLine().trim());

                if (output <= 0)
                    throw new NumberFormatException();
                break;

            } catch (NumberFormatException error) {
                System.out.printf("%s\n%n", ReadProperties.getProperty("error.show.expect-integer"));
            }
        }

        return output;
    };

    @Overload
    public static int handleInteger(String question, int limitNumberOfInput) {
        int output;

        while (true) {
            try {
                System.out.print(question);
                output = Integer.parseInt(read.nextLine().trim());

                if (output <= 0 || output > limitNumberOfInput)
                    throw new NumberFormatException();
                break;

            } catch (NumberFormatException error) {
                System.out.printf("%s\n%n", ReadProperties.getProperty("error.show.expect-integer"));
            }
        }

        return output;
    }

    public static double handleDouble(String question) {
        double output;

        while (true) {
            try {
                System.out.print(question);
                output = Double.parseDouble(read.nextLine().trim());

                if (output <= 0)
                    throw new NumberFormatException();
                break;

            } catch (NumberFormatException error) {
                System.out.printf("%s\n%n", ReadProperties.getProperty("error.show.expect-double"));
            }
        }

        return output;
    }
}
