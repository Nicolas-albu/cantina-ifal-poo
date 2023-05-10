package com.ifal.cantina.utils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HandleInput {
    private Scanner read;

    public HandleInput(Scanner read) {
        this.read = read;
    }

    public String handle(String message) {
        String output = null;
        
        while (output == null) {
            try {
                System.out.print(message);
                output = this.read.nextLine();
    
            } catch (NoSuchElementException error) {
                System.err.println(ReadProperties.getProperty("error.show.expect-string"));
                
                continue;
            } catch (Exception error) {
                boolean existInteger = output.matches(ReadProperties.getProperty("util.exist-integer"));
                boolean existDouble = output.matches(ReadProperties.getProperty("util.exist-double"));
                
                if (error instanceof InputMismatchException && existInteger)
                    System.err.println(ReadProperties.getProperty("error.show.expect-integer"));
                if (error instanceof InputMismatchException && existDouble)
                    System.err.println(ReadProperties.getProperty("error.show.expect-double"));
                
                continue;
            }
        }

        return output;
    }
}
