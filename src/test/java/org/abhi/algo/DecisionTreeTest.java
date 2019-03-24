package org.abhi.algo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DecisionTreeTest {

    final List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4 , 5, 5);
    final List<Integer> matchList = Arrays.asList(5, 4, 3, 2, 1);

    @Test
    public void divideListToTwoEqualSets() {
        Map<String, List<Integer>> result = DecisionTree.divideListToTwoEqualSets(list);
        result.forEach((key, value) -> assertEquals(matchList, value));
    }
}