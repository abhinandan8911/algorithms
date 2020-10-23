import java.util.Scanner;

public class CopyPaste {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCases; i++) {
            String[] nkArray = scanner.nextLine().split(" ");
            String[] pilesArray = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nkArray[0]);
            int k = Integer.parseInt(nkArray[1]);

            int[] piles = new int[n];
            for (int j = 0; j < n; j++) {
                piles[j] = Integer.parseInt(pilesArray[j]);
            }
            int copyPaste=0;
            for (int j = 0; j < piles.length; j++) {
                int minIndex = indexOfMinimum(piles);
                for (int l = 0; l < piles.length; l++) {
                    if((l != minIndex) && (piles[minIndex] + piles[l] <= k)) {
                        piles[l] = piles[l] + piles[minIndex];
                        ++copyPaste;
                    }
                }
            }
            System.out.println(copyPaste);

        }
    }

    private static int indexOfMinimum(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

}
