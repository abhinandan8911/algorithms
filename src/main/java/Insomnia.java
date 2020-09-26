import java.util.Scanner;

public class Insomnia {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int d = Integer.parseInt(scanner.nextLine());
        int[] list = new int[d];
        for (int i = 0; i < d ; i++) {
            int mul_k = (i + 1)  * k;
            int mul_l = (i + 1) * l;
            int mul_m = (i + 1) * m;
            int mul_n = (i + 1) * n;
            if(mul_k <= d) {
                list[mul_k - 1] = 1;
            }
            if(mul_l <= d) {
                list[mul_l - 1] = 1;
            }
            if(mul_m <= d) {
                list[mul_m - 1] = 1;
            }
            if(mul_n <= d) {
                list[mul_n - 1] = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < d; i++) {
            if(list[i] == 1) {
                ++count;
            }
        }
        System.out.println(count);
    }
}
