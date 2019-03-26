package org.abhi.algo;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static boolean binarySearch(Integer target, Integer...integers) {
        List<Integer> integerList = Arrays.asList(integers);
        List<Integer> workingCopy = ListUtilities.sortedList(integerList, true);
        int low = 0, high = workingCopy.size() - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(target == workingCopy.get(mid)) {
                return true;
            }
            if(target < workingCopy.get(mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
}
