import java.util.Scanner;

public class Elephant {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int coordinate = scanner.nextInt();
        int numberOfSteps = 0;
        int[] possibleMoves = {1,2,3,4,5};
        for (int i = possibleMoves.length - 1; i >= 0 ; i--) {
            int divisor = possibleMoves[i];
            while(coordinate > 0 && coordinate >= divisor) {
                if(coordinate == 1) {
                    numberOfSteps++;
                    break;
                }
                else {
                    int times = coordinate / divisor;
                    coordinate = coordinate % divisor;
                    numberOfSteps = numberOfSteps + times;
                }
            }
        }
        System.out.println(numberOfSteps);
    }
}
