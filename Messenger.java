package numbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Messenger {

    private final List<String> properties =
            List.of("buzz", "duck", "palindromic", "gapful", "spy", "even", "odd", "square", "sunny");

    private final String[][] exclusiveProperties = new String[][]
                    {{"even", "odd"},
                    {"duck", "spy"},
                    {"square", "sunny"},};

    public List<String> getProperties() {
        return properties;
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- two natural numbers and two properties to search for;");
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
        System.out.printf("The property [%s] is wrong.%n", property.toUpperCase());
        printAvailableProperties();
    }

    public void errorMessage4(String property1, String property2) {
        System.out.printf("The properties [%s, %s] are wrong.%n",
                property1.toUpperCase(), property2.toUpperCase());
        printAvailableProperties();
    }

    public void errorMessage5(String property1, String property2) {
        System.out.printf("The request contains mutually exclusive properties: [%s, %s]%n",
                property1.toUpperCase(), property2.toUpperCase());
        System.out.println("There are no numbers with these properties.");
    }

    private void printAvailableProperties() {
        System.out.println("Available properties: " +
                "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
    }

    public boolean areNotExclusive(String property1, String property2) {
        String[] propArray = new String[]{property1, property2};
        Arrays.sort(propArray);
        boolean areValid = true;
        for (String[] properties : exclusiveProperties) {
            if (Arrays.equals(propArray, properties)) {
                areValid = false;
                break;
            }
        }
        return areValid;
    }
}
