import java.util.Scanner;

public class EasyProblem {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String[] opinions = scanner.nextLine().split(" ");
        boolean isEasy = true;
        for (int i = 0; i < numberOfPeople; i++) {
            if(opinions[i].equals("1")) {
                isEasy = false;
                break;
            }
        }
        if(isEasy) {
            System.out.println("EASY");
        }
        else {
            System.out.println("HARD");
        }
    }
}
