package numbers;

public class Number {

    private final long number;

    public Number(long number) {
        this.number = number;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

    public boolean isOdd() {
        return number % 2 == 1;
    }

    public boolean isBuzz() {
        return number % 7 == 0 || number % 10 == 7;
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

    public boolean isSquare() {
        int sqrt = (int) Math.sqrt(number);
        return Math.pow(sqrt, 2) == number;
    }

    public boolean isSunny() {
        Number num = new Number(number + 1);
        return num.isSquare();
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
        System.out.printf("%12s: %b%n", "square", isSquare());
        System.out.printf("%12s: %b%n", "sunny", isSunny());
    }

    public void printProperties(int length) {
        for (long i = number; i < number + length; i++) {
            evaluateNumber(new Number(i));
        }
    }

    public void printProperties(int length, String property) {
        long i = number;
        int counter = 0;
        while (true) {
            Number num = new Number(i);
            boolean isValid = isPropertyMatched(num, property);
            if (isValid) {
                evaluateNumber(num);
                counter++;
            }
            if (counter == length || i == Long.MAX_VALUE) {
                break;
            }
            i++;
        }
    }

    public void printProperties(int length, String property1, String property2) {
        long i = number;
        int counter = 0;
        while (true) {
            Number num = new Number(i);
            boolean isValid1 = isPropertyMatched(num, property1);
            boolean isValid2 = isPropertyMatched(num, property2);
            if (isValid1 && isValid2) {
                evaluateNumber(num);
                counter++;
            }
            if (counter == length || i == Long.MAX_VALUE) {
                break;
            }
            i++;
        }
    }

    private void evaluateNumber(Number num) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(13)).append(num.number).append(" is ");
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
        if (num.isSquare()) {
            sb.append(", square");
        }
        if (num.isSunny()) {
            sb.append(", sunny");
        }
        System.out.println(sb);
    }

    private boolean isPropertyMatched(Number num, String property) {
        boolean isMatched = false;
        switch (property) {
            case "even":
                isMatched = num.isEven();
                break;
            case "odd":
                isMatched = num.isOdd();
                break;
            case "buzz":
                isMatched = num.isBuzz();
                break;
            case "duck":
                isMatched = num.isDuck();
                break;
            case "palindromic":
                isMatched = num.isPalindrome();
                break;
            case "gapful":
                isMatched = num.isGapful();
                break;
            case "spy":
                isMatched = num.isSpy();
                break;
            case "square":
                isMatched = num.isSquare();
                break;
            case "sunny":
                isMatched = num.isSunny();
                break;
        }
        return isMatched;
    }
}
