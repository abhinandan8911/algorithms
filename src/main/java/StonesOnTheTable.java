import java.util.Scanner;

public class StonesOnTheTable {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numberOfStones = scanner.nextInt();
        scanner.nextLine();
        final String stones = scanner.nextLine();
        int count = 0;
        if(numberOfStones != 0 && (stones != null && stones.length() > 0)) {
            for (int i = 1; i < numberOfStones; i++) {
                char next = stones.charAt(i);
                char previous = stones.charAt(i -1);
                if(previous == next) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

