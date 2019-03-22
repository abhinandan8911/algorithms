package org.abhi.algo;

import java.util.*;
import java.util.stream.Collectors;

import static org.abhi.algo.ListUtilities.*;

public class DecisionTree {

    public static final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private static List<Integer> firstList, secondList;
    private static Map<String, List<Integer>> returnMap;

    private static void initialize() {
        firstList = new ArrayList<>();
        secondList = new ArrayList<>();
        returnMap = new HashMap<>();
    }



    public static Map<String, List<Integer>> divideListToTwoEqualSets(List<Integer> srcList) {
        List<Integer> workingList = sortedList(srcList, false);
        System.out.println("The sorted list is : " + workingList.stream().map(String::valueOf).collect(Collectors.joining(" , ")));
        initialize();
        workingList.forEach(DecisionTree::partitionList);
        returnMap.put("firstSet", firstList);
        returnMap.put("secondSet", secondList);
        return returnMap;
    }

    private static void partitionList(Integer item) {
        Integer firstSumDiff, secondSumDiff;
        firstList.add(item);
        firstSumDiff = absIntegerDifference(getSumFromIntegerSet(firstList), getSumFromIntegerSet(secondList));
        firstList.remove(item);
        secondList.add(item);
        secondSumDiff = absIntegerDifference(getSumFromIntegerSet(firstList), getSumFromIntegerSet(secondList));
        secondList.remove(item);
        System.out.println("First Sum difference : " + firstSumDiff + " Second Sum difference : " + secondSumDiff + " for the item : " + item);
        if(firstSumDiff <= secondSumDiff) {
            System.out.println("Added element to first : " + item);
            firstList.add(item);
        }
        else {
            System.out.println("Added element to second : " + item);
            secondList.add(item);
        }
    }



}
