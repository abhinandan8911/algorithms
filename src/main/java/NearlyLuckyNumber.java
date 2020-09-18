import java.util.Scanner;

public class NearlyLuckyNumber {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        long count = 0;
        while (input > 0) {
            long digit = input % 10;
            if(digit == 4 || digit == 7) {
                ++count;
            }
            input = input / 10;
        }
        boolean isLucky = count > 0 ? isLucky(count) : false;
        if(isLucky) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static boolean isLucky(long number) {
        while(number > 0) {
            long digit = number % 10;
            if(digit != 4 && digit != 7) {
                return false;
            }
            else {
                number = number / 10;
            }
        }
        return true;
    }
}
