import java.util.Scanner;

public class LexicographixCompare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        if((firstLine != null && firstLine.length() > 0) && (secondLine !=null && secondLine.length() > 0)) {
            int toPrint = 0;
            if(firstLine.compareToIgnoreCase(secondLine) > 0) {
                toPrint = 1;
            }
            else if (firstLine.compareToIgnoreCase(secondLine) < 0) {
                toPrint = -1;
            }
            System.out.println(toPrint);
        }
    }
}
