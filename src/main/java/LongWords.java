import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords = scanner.nextInt();
        List<String> output = new ArrayList<>();
        for (int i = 0; i <= numberOfWords; i++) {
            String word = scanner.nextLine();
            if(word.length() > 10) {
                int lengthOfWord = word.length();
                int lengthInBetween = lengthOfWord - 2;
                String wordOutput = word.substring(0,1) + lengthInBetween + word.substring(lengthOfWord -1);
                output.add(wordOutput);
            }
            else {
                output.add(word);
            }
        }
        output.forEach(System.out::println);
        scanner.close();
    }
}
