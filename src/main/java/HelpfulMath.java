import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HelpfulMath {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String inputLine = scanner.nextLine();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputLine.length(); i++) {
            final char charAt = inputLine.charAt(i);
            if(charAt != '+') {
                numbers.add(Character.getNumericValue(charAt));
            }
        }
        numbers.sort(Integer::compareTo);
        String finalResult = numbers.stream().map(String::valueOf).collect(Collectors.joining("+"));
        System.out.println(finalResult);
    }
}
