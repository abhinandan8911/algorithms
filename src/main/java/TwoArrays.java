import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TwoArrays {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCases; i++) {
            List<Integer> white = new ArrayList<>();
            List<Integer> black = new ArrayList<>();
            String[] nt = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nt[0]);
            int t = Integer.parseInt(nt[1]);
            List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> results = new ArrayList<>();
            for (Integer x :  numbers) {
                if(test(white, x, t)) {
                    white.add(x);
                    results.add(0);
                }
                else {
                    black.add(x);
                    results.add(1);
                }
            }
            System.out.println(results.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    private static boolean test(List<Integer> list, Integer x, Integer magicValue) {
        boolean add = true;
        for(Integer num : list) {
            if(num + x == magicValue) {
                add = false;
                break;
            }
        }
        return add;
    }
}
