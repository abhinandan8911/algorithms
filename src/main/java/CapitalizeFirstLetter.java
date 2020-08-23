import java.util.Scanner;

public class CapitalizeFirstLetter {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line != null && line.length() > 0) {
            line = line.substring(0, 1).toUpperCase().concat(line.substring(1));
        }
        System.out.println(line);
    }
}
