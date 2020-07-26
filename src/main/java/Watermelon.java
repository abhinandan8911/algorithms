import java.io.IOException;
import java.util.Scanner;

public class Watermelon {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        if (w >= 4 && w % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


}
