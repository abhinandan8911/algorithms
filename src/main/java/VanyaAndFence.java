import java.util.Scanner;

public class VanyaAndFence {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] firstLine = scanner.nextLine().split(" ");
        final String[] secondLine = scanner.nextLine().split(" ");
        int fenceHeight = Integer.parseInt(firstLine[1]);
        int width = 0;
        for (int i = 0; i < secondLine.length; i++) {
            int height = Integer.parseInt(secondLine[i]);
            if(height > fenceHeight) {
                width = width + 2;
            }
            else {
                ++width;
            }
        }
        System.out.println(width);
    }
}
