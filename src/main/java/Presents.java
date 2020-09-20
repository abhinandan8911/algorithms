import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String [] distribution = scanner.nextLine().split(" ");
        List<Integer> distributionList = new ArrayList<>();
        Arrays.stream(distribution).mapToInt(Integer::parseInt).forEach(distributionList::add);
        for (int i = 1; i <= distributionList.size(); i++) {
            System.out.print(distributionList.indexOf(i) + 1 + " ");
        }
    }
}
