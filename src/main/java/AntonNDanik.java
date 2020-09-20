import java.util.Scanner;

public class AntonNDanik {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String lengthStr = scanner.nextLine();
        final String result = scanner.nextLine();
        int length = Integer.parseInt(lengthStr);
        char[] resultArray = result.toCharArray();
        int anton =0, danik = 0;
        for (int i = 0; i < length; i++) {
            if(resultArray[i] == 'A') {
                ++anton;
            }
            else {
                ++danik;
            }
        }
        if(anton == danik) {
            System.out.println("Friendship");
        }
        else if(anton > danik) {
            System.out.println("Anton");
        }
        else {
            System.out.println("Danik");
        }
    }
}
