import java.util.Arrays;
import java.util.Scanner;

public class Team {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = scanner.nextInt();
        int counter = 0;
        for (int i = 0; i <= numberOfLines; i++) {
            String line = scanner.nextLine();
            if(line!= null && line.length() > 0) {
                String[] strings = line.split(" ");
                int sum = Arrays.stream(strings).map(Integer::parseInt).reduce(0, (a, b) -> a+b);
                if(sum >= 2) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
        scanner.close();
    }
}
