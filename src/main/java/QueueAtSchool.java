import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QueueAtSchool {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] values = firstLine.split(" ");
        int numberOfChildren = Integer.parseInt(values[0]);
        int time = Integer.parseInt(values[1]);
        String secondLine = scanner.nextLine();
        List<Character> listOfChildren = new ArrayList<>();
        for (int i = 0; i < numberOfChildren; i++) {
            listOfChildren.add(secondLine.charAt(i));
        }
        for (int i = 0; i < time; i++) {
            for (int j = 0; j < listOfChildren.size(); ) {
                if((j < listOfChildren.size() - 1) && listOfChildren.get(j).equals('B') && listOfChildren.get(j+1).equals('G')) {
                    listOfChildren.set(j , 'G');
                    listOfChildren.set(j+1, 'B');
                    j = j + 2;
                }
                else {
                    ++j;
                }
            }
        }
        System.out.println(listOfChildren.stream().map(String::valueOf).collect(Collectors.joining("")));
    }
}
