import java.util.Scanner;

public class FunctionCalc {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        long number = Long.parseLong(scanner.nextLine());
        long sum = 0;
        if (number % 2 == 0) {
            long div = number / 2;
            sum = div;
        } else {
            long div = (number - 1) / 2;
            sum = div - number;
        }
        System.out.println(sum);
    }
}
