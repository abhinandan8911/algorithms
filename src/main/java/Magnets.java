import java.util.Scanner;

public class Magnets {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        String[] input = new String[numberOfInputs];
        for (int i = 0; i< numberOfInputs; i++) {
            input[i] = scanner.nextLine();
        }
        int groups = 1;
        for (int i = 0; i < numberOfInputs; i++) {
            if((i < numberOfInputs - 1) && (!input[i].equals(input[i+1]))) {
                groups++;
            }
        }
        System.out.println(groups);
    }
}
