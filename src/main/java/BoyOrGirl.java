import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoyOrGirl {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String username = scanner.nextLine();
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < username.length(); i++) {
            Character character = username.charAt(i);
            characters.add(character);
        }
        if(characters.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        }
        else {
            System.out.println("IGNORE HIM!");
        }
    }
}
