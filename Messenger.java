package numbers;

import java.util.Scanner;

public class Messenger {

    public void welcomeMessage() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    public void goodbyeMessage() {
        System.out.println("Goodbye!");
    }

    public String takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a request: ");
        String input = sc.nextLine();
        System.out.println();
        return input.trim();
    }

    public void errorMessage1() {
        System.out.println("The first parameter should be a natural number or zero.");
    }

    public void errorMessage2() {
        System.out.println("The second parameter should be a natural number.");
    }

    public void errorMessage3(String property) {
        System.out.printf("The property [%s] is wrong.%n", property);
        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
    }
}
