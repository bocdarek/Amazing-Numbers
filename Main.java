package numbers;

public class Main {
    public static void main(String[] args) {

        Messenger msg = new Messenger();
        msg.welcomeMessage();
        while (true) {
            String input = msg.takeInput();
            if (input.isEmpty()) {
                msg.welcomeMessage();
                continue;
            }
            if (input.equals("0")) {
                msg.goodbyeMessage();
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
                msg.errorMessage1();
                continue;
            }
            Number number = new Number(num1);
            if (inputs.length == 1) {
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
                msg.errorMessage2();
                continue;
            }
            if (inputs.length == 2) {
                number.printProperties(num2);
                continue;
            }
            String property1 = inputs[2].toLowerCase();
            if (inputs.length == 3) {
                if (msg.getProperties().contains(property1)) {
                    number.printProperties(num2, property1);
                } else {
                    msg.errorMessage3(property1);
                }
                continue;
            }
            String property2 = inputs[3].toLowerCase();
            if (msg.getProperties().contains(property1) && msg.getProperties().contains(property2)) {
                if (msg.areNotExclusive(property1, property2)) {
                    number.printProperties(num2, property1, property2);
                } else {
                    msg.errorMessage5(property1, property2);
                }
            } else {
                msg.errorMessage4(property1, property2);
            }
        }
    }
}
