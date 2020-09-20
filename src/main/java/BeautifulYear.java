import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BeautifulYear {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String inputYearStr = scanner.nextLine();
        int inputYear = Integer.parseInt(inputYearStr);
        int distinctYear = Integer.MAX_VALUE;
        for (int i = inputYear + 1; i <= Integer.MAX_VALUE; i++) {
            if(isDistinct(i)) {
                distinctYear = i;
                break;
            }
        }
        System.out.println(distinctYear);
    }

    private static boolean isDistinct(int year) {
        int[] digits = new int[4];
        int i = 0;
        while(year > 0 && i < 4) {
            digits[i++] = year % 10;
            year = year / 10;
        }
        final Set<Integer> digitSet = new HashSet<>();
        Arrays.stream(digits).forEach(digitSet::add);
        return digitSet.size() == 4;
    }
}
