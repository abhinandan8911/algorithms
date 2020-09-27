import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class HorseShoe {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        Set<Integer> shoes = Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toSet());
        System.out.println(input.length - shoes.size());
    }
}
