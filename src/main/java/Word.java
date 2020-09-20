import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String inputString = scanner.nextLine();
        int lowerCaseLetters = 0;
        int upperCaseLetters = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if(Character.isLowerCase(inputString.charAt(i))) {
                ++lowerCaseLetters;
            }
            else {
                ++upperCaseLetters;
            }
        }
        if(upperCaseLetters > lowerCaseLetters  ) {
            System.out.println(inputString.toUpperCase());
        }
        else {
            System.out.println(inputString.toLowerCase());
        }
    }
}
