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
            number.printProperties(num2);
        }

    }
}