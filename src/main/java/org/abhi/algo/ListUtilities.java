package org.abhi.algo;

import java.util.*;
import java.util.stream.Collectors;

public class ListUtilities {

    public static List<Integer> sortedList(List<Integer> srcList, boolean ascendingOrder) {
        List<Integer> workingCopy = new ArrayList<>(srcList);
        if(ascendingOrder) {
            Collections.sort(workingCopy);
            return Collections.unmodifiableList(workingCopy);
        }
        else {
            Collections.sort(workingCopy, Collections.reverseOrder());
            return Collections.unmodifiableList(workingCopy);
        }
    }

    public static int absIntegerDifference(Integer first, Integer second) {
        return Math.abs(first.intValue() - second.intValue());
    }

    public static <T> List<T> copyList(List<T> list) {
        return new ArrayList<>(list);
    }


    public static Integer getSumFromIntegerSet(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public static void printMapValues(final Map<String, List<Integer>> sourceMap) {
        sourceMap.forEach((name, setOfIntegers) -> {
            String listOfValues = setOfIntegers.stream().map(String::valueOf).collect(Collectors.joining(" , "));
            System.out.println("Name is : " + name + " Value is : " + listOfValues);
        });
    }

    public static <T> String printList(List<T> list) {
        return list.stream().map(Objects::toString).collect(Collectors.joining(" , "));
    }

    public static <T> String printFlatList(List<List<T>> list) {
        return list.stream().flatMap(ls -> ls.stream().map(Objects::toString)).collect(Collectors.joining(" , "));
    }
}
