import java.util.Scanner;

public class BearAndBigBrother {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        final String[] weights = input.split(" ");
        int limakWeight = Integer.parseInt(weights[0]);
        int bobWeight = Integer.parseInt(weights[1]);
        int years = 0;
        while (limakWeight <= bobWeight) {
            limakWeight = limakWeight * 3;
            bobWeight = bobWeight * 2;
            years++;
        }
        System.out.println(years);
    }
}
