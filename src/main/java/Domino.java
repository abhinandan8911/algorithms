import java.util.Scanner;

public class Domino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] firstLineNumbers;
        int m = 0, n = 0;
        int totalArea = 0;
        if(firstLine != null && firstLine.length() > 0) {
            firstLineNumbers = firstLine.split(" ");
            m = Integer.parseInt(firstLineNumbers[0]);
            n = Integer.parseInt(firstLineNumbers[1]);
        }
        totalArea = m * n;
        int numberOfDominos = totalArea / 2;
        System.out.println(numberOfDominos);
    }
}
