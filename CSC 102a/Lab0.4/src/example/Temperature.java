package example;

import java.util.Scanner;

public class Temperature {

    public static void main(String[] args){
        // variable to save users choice to
        int user_choice;
        double fahrenheit;
        double celsius;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("To convert F to C, press 1. \nTo convert from C to F, press 2");
        user_choice = keyboard.nextInt();

        switch(user_choice)
        {
            // Fahrenheit to Celsius
            case 1:
                System.out.println("Enter a temp in Fahrenheit: ");
                fahrenheit = keyboard.nextDouble();

                // Convert to celsius
                celsius = (fahrenheit - 32)*(5.0/9.0);
                // Print it out
                System.out.println("Your temperature in celsius is " + celsius);
                // Celsius to Fahnrenheit
                break;
            case 2:
                System.out.println("Enter a temp in Celsius:" );
                celsius = keyboard.nextDouble();

                // Convert to fahrenheit
                fahrenheit = (celsius*(9.0/5.0)) + 32.0;
                // Print it out
                System.out.println("Your temperature in fahrenheit is " + fahrenheit);
        }
    }
}
