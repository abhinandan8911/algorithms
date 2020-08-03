import java.util.Scanner;

public class Bit {
    private static final CharSequence PLUS = "+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInstructions = scanner.nextInt();
        int result = 0;
        for (int i = 0; i <= numberOfInstructions; i++) {
            String instruction = scanner.nextLine();
            if(instruction != null && instruction.length() > 0) {
                if(instruction.contains(PLUS)) {
                    result++;
                }
                else {
                    result--;
                }
            }
        }
        System.out.println(result);
    }
}
