package org.abhi.algo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SubsetsTest {

    final Integer[] ints = {-2, 1, -3, 4, -1, 2, 1, -5};
    final Integer[] contiguousInts = {4 , -1 , 2 , 1};
    final Integer[] improvedSubset = {-2 , 1 , -3 , 4};
    final Integer[] testSubset = {1, 2, 3};
    final Integer[] testZerSumSubset = {-5, 5, -4, 4, 3, -3, 1, 0, 2, -2};

    @Test
    public void getContiguousSubsets() {
        assertEquals(6, Subsets.getContiguousSubsets(1, 2, 3).size());
    }

    @Test
    public void partitionBasedOnTarget() {
        assertEquals(Arrays.asList(improvedSubset), Subsets.partitionBasedOnTarget(0, ints));
    }

    @Test
    public void maxContiguousSum() {
        assertEquals(Arrays.asList(contiguousInts), Subsets.maxContiguousSum(ints));
    }

    @Test
    public void generateSubsets() {
        List<List<Integer>> subsets = Subsets.generateSubsets(testSubset);
        for(List<Integer> subset : subsets) {
            System.out.println("Subset is : " + ListUtilities.printList(subset));
        }
    }

    @Test
    public void subsetHelper() {
        Subsets.subsetHelper(testSubset);
    }

    @Test
    public void getZeroSumSubset() {
        List<Integer> longestZeroSubset = Subsets.getZeroSumSubset(testZerSumSubset);
        System.out.println("The subset is : " + ListUtilities.printList(longestZeroSubset));
    }
}