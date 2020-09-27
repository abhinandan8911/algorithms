import java.util.Arrays;
import java.util.Scanner;

public class GeneralArrival {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] line2 = scanner.nextLine().split(" ");
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(line2[i]);
        }

        int indexOfMaxValue = minIndexOfMaxValue(heights);
        int swaps = 0;
        for (int i = indexOfMaxValue; i > 0; i--) {
            int value = heights[i-1];
            heights[i-1] = heights[i];
            heights[i] = value;
            ++swaps;
        }

        int indexOfMinValue = maxIndexOfMinValue(heights);
        for (int i = indexOfMinValue; i < heights.length - 1; i++) {
            int value = heights[i+1];
            heights[i+1] = heights[i];
            heights[i] = value;
            ++swaps;
        }

        System.out.println(swaps);

    }

    private static int minIndexOfMaxValue(int[] src) {
        int index = 0;
        int largestValue = src[0];
        for (int i = 1; i < src.length; i++) {
            if(src[i] > largestValue) {
                largestValue = src[i];
                index = i;
            }
        }
        return index;
    }

    private static int maxIndexOfMinValue(int[] src) {
        int index = 0;
        int smallestValue = src[0];
        for (int i = 1; i < src.length; i++) {
            if(src[i] <= smallestValue) {
                smallestValue = src[i];
                index = i;
            }
        }
        return index;
    }

}
