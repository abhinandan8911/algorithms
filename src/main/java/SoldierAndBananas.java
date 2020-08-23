import java.util.Scanner;

public class SoldierAndBananas {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        String[] values = input.split(" ");
        int costOfEach = Integer.parseInt(values[0]);
        int amount = Integer.parseInt(values[1]);
        int numberOfBananas = Integer.parseInt(values[2]);
        int sum = 0;
        for (int i = 1; i <= numberOfBananas; i++) {
            sum += i * costOfEach;
        }
        int difference = sum - amount;
        if(difference < 0) {
            System.out.println(0);
        }
        else {
            System.out.println(difference);
        }
    }
}
