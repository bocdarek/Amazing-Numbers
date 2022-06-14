package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        welcomeMessage();
        while (true) {
            String input = takeInput();
            if (input.isEmpty()) {
                welcomeMessage();
                continue;
            }
            if (input.equals("0")) {
                goodbyeMessage();
                return;
            }
            String[] inputs = input.split("\\s+");
            long num1;
            try {
                num1 = Long.parseLong(inputs[0]);
                if (num1 < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                errorMessage1();
                continue;
            }
            if (inputs.length == 1) {
                Number number = new Number(num1);
                number.printProperties();
                continue;
            }
            int num2;
            try {
                num2 = Integer.parseInt(inputs[1]);
                if (num2 < 1) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                errorMessage2();
                continue;
            }
            Number number = new Number(num1, num2);
            number.printList();
        }

    }

    private static void welcomeMessage() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    private static void goodbyeMessage() {
        System.out.println("Goodbye!");
    }

    private static String takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a request: ");
        String input = sc.nextLine();
        System.out.println();
        return input.trim();
    }

    private static void errorMessage1() {
        System.out.println("The first parameter should be a natural number or zero.");
    }

    private static void errorMessage2() {
        System.out.println("The second parameter should be a natural number.");
    }
}
