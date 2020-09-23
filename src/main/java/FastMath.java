import java.util.Scanner;

public class FastMath {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String firstLine = scanner.nextLine();
        final String secondLine = scanner.nextLine();
        char[] chars = new char[firstLine.length()];
        for (int i = 0; i < firstLine.length(); i++) {
            int first = Character.getNumericValue(firstLine.charAt(i));
            int second = Character.getNumericValue(secondLine.charAt(i));
            chars[i] = Character.forDigit(first ^ second, 10);
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }
}
