import java.util.Arrays;
import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String[] args) {
        final int BEAUTIFUL_ROW = 2;
        final int BEAUTIFUL_COLUMN = 2;
        final Scanner scanner = new Scanner(System.in);

        String[] matrix = new String[5];
        for (int i = 0; i < 5; i++) {
            final String line = scanner.nextLine();
            if (line != null && line.length() > 0) {
                matrix[i] = line;
            }
        }
        int column = 0, row = 0;
        for (int i = 0; i < 5; i++) {
            if (matrix[i].contains("1")) {
                row = i;
                column = matrix[row].replaceAll("\\s+", "").indexOf("1");
            }
        }
        int rowShift = Math.abs(BEAUTIFUL_ROW - row);
        int columnShift = Math.abs(BEAUTIFUL_COLUMN - column);
        System.out.println(rowShift + columnShift);
    }
}
