package numbers;

import java.util.*;

public class Messenger {

    private final List<String> availableProperties =
            List.of("BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD", "SQUARE",
                    "SUNNY", "JUMPING", "HAPPY", "SAD");

    private final List<String> oppositeProperties =
            List.of("-BUZZ", "-DUCK", "-PALINDROMIC", "-GAPFUL", "-SPY", "-EVEN", "-ODD", "-SQUARE",
                    "-SUNNY", "-JUMPING", "-HAPPY", "-SAD");

    private final String[][] exclusivePropertiesArray = new String[][]
                    {{"EVEN", "ODD"},
                    {"DUCK", "SPY"},
                    {"SQUARE", "SUNNY"},
                    {"HAPPY", "SAD"},
                    {"-EVEN", "-ODD"},
                    {"-HAPPY", "-SAD"},
                    {"EVEN", "-EVEN"},
                    {"ODD", "-ODD"},
                    {"BUZZ", "-BUZZ"},
                    {"DUCK", "-DUCK"},
                    {"PALINDROMIC", "-PALINDROMIC"},
                    {"GAPFUL", "-GAPFUL"},
                    {"SQUARE", "-SQUARE"},
                    {"SUNNY", "-SUNNY"},
                    {"JUMPING", "-JUMPING"},
                    {"HAPPY", "-HAPPY"},
                    {"SAD", "-SAD"}};

    public void welcomeMessage() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        printInstructions();
    }

    public void printInstructions() {
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        printAvailableProperties();
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

    public void errorMessage3(List<String> properties) {
        List<String> wrongProperties = new ArrayList<>();
        for (String property : properties) {
            if (!(availableProperties.contains(property) || oppositeProperties.contains(property))) {
                wrongProperties.add(property);
            }
        }
        if (wrongProperties.size() == 1) {
            System.out.println("The property " + wrongProperties + " is wrong.");
        } else {
            System.out.println("The properties " + wrongProperties + " are wrong.");
        }
        printAvailableProperties();
    }

    public void errorMessage4(List<String> properties) {
        Set<String> allExclusives = new HashSet<>();
        for (String[] exclusiveProperties : exclusivePropertiesArray) {
            if (properties.containsAll(List.of(exclusiveProperties))) {
                allExclusives.addAll(List.of(exclusiveProperties));
            }
        }
        System.out.println("The request contains mutually exclusive properties: " + allExclusives);
        System.out.println("There are no numbers with these properties.");
    }

    private void printAvailableProperties() {
        System.out.print("- Available properties: ");
        System.out.println(availableProperties);
    }

    public boolean areAllValid(List<String> properties) {
        for (String property : properties) {
            if (!(availableProperties.contains(property) || oppositeProperties.contains(property))) {
                return false;
            }
        }
        return true;
    }

    public boolean areNotExclusive(List<String> properties) {
        for (String[] exclusiveProperties : exclusivePropertiesArray) {
            if (properties.containsAll(List.of(exclusiveProperties))) {
                return false;
            }
        }
        return true;
    }
}
