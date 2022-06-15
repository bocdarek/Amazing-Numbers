package numbers;

public class Number {

    private final long number;
    private int length;

    public Number(long number) {
        this.number = number;
    }

    public Number(long number, int length) {
        this(number);
        this.length = length;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

    public boolean isOdd() {
        return number % 2 == 1;
    }

    public boolean isBuzz() {
        return  number % 7 == 0 || number % 10 == 7;
    }

    public boolean isDuck() {
        String digits = String.valueOf(number);
        return digits.contains("0");
    }

    public boolean isPalindrome() {
        String numString = String.valueOf(number);
        int length = numString.length();
        boolean temp = true;
        for (int i = 0; i < length / 2 + 1; i++) {
            if (numString.charAt(i) != numString.charAt(length - 1 - i)) {
                temp = false;
                break;
            }
        }
        return temp;
    }

    public boolean isGapful() {
        if (number < 100) {
            return false;
        }
        String numString = String.valueOf(number);
        int divider = Integer.parseInt(String.format("%c%c",
                numString.charAt(0), numString.charAt(numString.length() - 1)));
        return number % divider == 0;
    }

    public boolean isSpy() {
        String[] numArray = String.valueOf(number).split("");
        int sum = 0;
        int product = 1;
        for (String s : numArray) {
            int num = Integer.parseInt(s);
            sum += num;
            product *= num;
        }
        return sum == product;
    }

    public void printProperties() {
        System.out.printf("Properties of %,d%n", number);
        System.out.printf("%12s: %b%n", "even", isEven());
        System.out.printf("%12s: %b%n", "odd", isOdd());
        System.out.printf("%12s: %b%n", "buzz", isBuzz());
        System.out.printf("%12s: %b%n", "duck", isDuck());
        System.out.printf("%12s: %b%n", "palindromic", isPalindrome());
        System.out.printf("%12s: %b%n", "gapful", isGapful());
        System.out.printf("%12s: %b%n", "spy", isSpy());
    }

    public void printList() {
        for (long i = number; i < number + length; i++) {
            StringBuilder sb = new StringBuilder();
            Number num = new Number(i);
            sb.append(" ".repeat(13)).append(i).append(" is ");
            if (num.isEven()) {
                sb.append("even");
            } else {
                sb.append("odd");
            }
            if (num.isBuzz()) {
                sb.append(", buzz");
            }
            if (num.isDuck()) {
                sb.append(", duck");
            }
            if (num.isPalindrome()) {
                sb.append(", palindromic");
            }
            if (num.isGapful()) {
                sb.append(", gapful");
            }
            if (num.isSpy()) {
                sb.append(", spy");
            }
            System.out.println(sb);
        }
    }
}
