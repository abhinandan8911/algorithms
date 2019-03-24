package org.abhi.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.abhi.algo.ListUtilities.*;

public class Subsets {


    public static List<List<Integer>> getContiguousSubsets(Integer... integers) {
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < integers.length; i++) {
            List<Integer> subsetList = new ArrayList<>();
            for (int j = i; j < integers.length; j++) {
                subsetList.add(integers[j]);
                returnList.add(copyList(subsetList));
            }
        }
        return returnList;
    }

    public static List<Integer> partitionBasedOnTarget(int target, Integer... integers) {
        List<Integer> bestList = new ArrayList<>();
        List<List<Integer>> contiguousSubsets = getContiguousSubsets(integers);
        List<List<Integer>> targetMatchingList = contiguousSubsets.stream().filter(ls -> getSumFromIntegerSet(ls) == target).collect(Collectors.toList());
        int maxSize = Integer.MIN_VALUE;
        for(List<Integer> matchingList : targetMatchingList) {
            if(matchingList.size() > maxSize) {
                maxSize = matchingList.size();
                bestList = copyList(matchingList);
            }
        }
        return bestList;
    }

    public static List<Integer> maxContiguousSum(Integer...integers) {
        List<List<Integer>> listOfContoguousSubsets = getContiguousSubsets(integers);
        List<Integer> bestList = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        for (List<Integer> subset:listOfContoguousSubsets) {
            int totalValue = getSumFromIntegerSet(subset);
            if(totalValue > maxSum) {
                maxSum = totalValue;
                bestList = copyList(subset);
            }
        }
        return bestList;
    }
}
