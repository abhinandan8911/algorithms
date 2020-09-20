import java.util.Scanner;

public class Translation {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String s = scanner.nextLine();
        final String t = scanner.nextLine();
        if(s.length() != t.length()) {
            System.out.println("NO");
        }
        else {
            boolean match = true;
            for (int i = 0, j = s.length() - 1; i < s.length() && j >= 0; i++, j--) {
                if(s.charAt(i) != t.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if(match) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
