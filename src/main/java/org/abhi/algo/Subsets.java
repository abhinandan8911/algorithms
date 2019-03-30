package org.abhi.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.abhi.algo.ListUtilities.*;

public class Subsets {

    private static List<Integer> bestZeroSumList;


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
        List<List<Integer>> contiguousSubsets = getContiguousSubsets(integers);
        List<List<Integer>> targetMatchingList = contiguousSubsets.stream().filter(ls -> getSumFromIntegerSet(ls) == target).collect(Collectors.toList());
        int maxSize = Integer.MIN_VALUE;
        return getList(maxSize, targetMatchingList);
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

    public static List<Integer> getZeroSumSubset(Integer...integers) {
        List<List<Integer>> allSubsetsForIntegers = generateSubsets(integers);
        int maxLength = Integer.MIN_VALUE;
        List<List<Integer>> zeroSumSubsetList = allSubsetsForIntegers.stream().filter(subset -> getSumFromIntegerSet(subset) == 0).collect(Collectors.toList());
        return getList(maxLength, zeroSumSubsetList);
    }

    private static List<Integer> getList(int maxLength, List<List<Integer>> zeroSumSubsetList) {
        List<Integer> longestZeroSubset = new ArrayList<>();
        for (List<Integer> zeroSubset : zeroSumSubsetList) {
            if (zeroSubset.size() > maxLength) {
                maxLength = zeroSubset.size();
                longestZeroSubset = copyList(zeroSubset);
            }
        }
        return longestZeroSubset;
    }

    public static List<List<Integer>> generateSubsets(Integer...integers) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<String> bitRepresentedSubsets = subsetHelper(integers);
        for(String eachString : bitRepresentedSubsets) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < eachString.length(); i++) {
                if(eachString.charAt(i) == '1') {
                    subset.add(integers[i]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }

    public static List<String> subsetHelper(Integer[] src) {
        List<String> listOfBitString = new ArrayList<>();
        Double maxNumber = Math.pow(2, src.length) - 1;
        int maxBits = Integer.toBinaryString(maxNumber.intValue()).length();
        for (int i = 1; i <= maxNumber; i++) {
            String bitRepresentation = Integer.toBinaryString(i);
            String str = "";
            for (int j = 0; j < (maxBits - bitRepresentation.length()); j++) {
                str += "0";
            }
            listOfBitString.add(str + bitRepresentation);
        }
        return listOfBitString;
    }

    public static List<Integer> exhaustiveSearchForZeroSubset(Integer... integers) {
        bestZeroSumList = new ArrayList<>();
        exhaustiveSearchHelper(0, integers, new ArrayList<>());
        return bestZeroSumList;
    }

    private static void exhaustiveSearchHelper(int index, Integer[] srcList, List<Integer> intermediateSolutionList) {
        if(index > srcList.length - 1) {
            if(ListUtilities.getSumFromIntegerSet(intermediateSolutionList) == 0) {
                if(intermediateSolutionList.size() > bestZeroSumList.size()) {
                    bestZeroSumList = copyList(intermediateSolutionList);
                }
            }
        }
        else {
            intermediateSolutionList.add(srcList[index]);
            exhaustiveSearchHelper(index + 1, srcList, intermediateSolutionList);
            intermediateSolutionList.remove(srcList[index]);
            exhaustiveSearchHelper(index + 1, srcList, intermediateSolutionList);
        }
    }
}
