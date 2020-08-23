import java.util.Scanner;

public class WrongSubtraction {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split(" ");
        int number = Integer.parseInt(values[0]);
        int numberOfOps = Integer.parseInt(values[1]);
        while (numberOfOps > 0) {
            if(number % 10 == 0) {
                number /= 10;
            }
            else {
                number -= 1;
            }
            numberOfOps--;
        }
        System.out.println(number);
    }
}
