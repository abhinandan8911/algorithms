import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AntonLetters {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String cleaned = input.replace("{", "");
        String finalString = cleaned.replace("}", "");
        String[] values = finalString.split(", ");
        Set<String> set = Arrays.stream(values).filter(str -> Objects.nonNull(str) && str.trim().length() > 0).collect(Collectors.toSet());
        System.out.println(set.size());
    }
}
