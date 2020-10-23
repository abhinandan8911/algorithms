import java.util.ArrayList;
import java.util.List;

public class ArraySubsets {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        getSubsets(array);
        int[][] subsets = getSubsets(array);
        for (int i = 0; i < (1 << array.length) - 1; i++) {
            int[] row = subsets[i];
            System.out.print("[");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + " , ");
            }
            System.out.println("]");
        }
    }

    private static int[][] getSubsets(int[] src) {
        int length = src.length;
        int numberOfSubsets = (1 << length);
        int[][] subsets = new int[numberOfSubsets-1][];
        int count = 0;
        for(int j = 1; j < numberOfSubsets; j++) {
            List<Integer> rows = new ArrayList<>();
            for(int k = 0; k < length; k++) {
                if((j & (1 << k)) > 0) {
                    rows.add(src[k]);
                }
            }
            int[] row = new int[rows.size()];
            for (int i = 0; i < rows.size(); i++) {
                row[i] = rows.get(i);
            }
            subsets[count++] = row;
        }
        return subsets;
    }
}
