import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NextRound {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String[] firstLineNumbers;
        String[] secondLineNumbers;
        int n = 0, k = 0;
        List<Integer> scores = null;
        if(firstLine != null && firstLine.length() > 0) {
            firstLineNumbers = firstLine.split(" ");
            n = Integer.parseInt(firstLineNumbers[0]);
            k = Integer.parseInt(firstLineNumbers[1]);
        }
        if(secondLine != null && secondLine.length() > 0) {
            secondLineNumbers = secondLine.split(" ");
            scores = Stream.of(secondLineNumbers).map(Integer::parseInt).collect(Collectors.toList());
        }
        int kthScore = scores.get(k-1);
        int countParticipants = 0;
        for (int i = 0; i < scores.size(); i++) {
            if(scores.get(i) > 0 && scores.get(i) >= kthScore) {
                countParticipants++;
            }
        }
        System.out.println(countParticipants);
        scanner.close();
    }
}
