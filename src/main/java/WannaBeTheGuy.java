import java.util.*;

public class WannaBeTheGuy {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberOfLevels = Integer.parseInt(scanner.nextLine());
        String[] inputLine1 = scanner.nextLine().split(" ");
        String[] inputLine2 = scanner.nextLine().split(" ");
        List<String> littleX = new ArrayList<>();
        for (int i = 1; i < inputLine1.length; i++) {
            littleX.add(inputLine1[i]);
        }
        List<String> littleY = new ArrayList<>();
        for (int i = 1; i < inputLine2.length; i++) {
            littleY.add(inputLine2[i]);
        }
        Set<Integer> levels = new HashSet<>();

        littleX.stream().map(Integer::parseInt).forEach(levels::add);
        littleY.stream().map(Integer::parseInt).forEach(levels::add);

        if(levels.size() == numberOfLevels) {
            System.out.println("I become the guy.");
        } else {
            System.out.println("Oh, my keyboard!");
        }
    }
}
