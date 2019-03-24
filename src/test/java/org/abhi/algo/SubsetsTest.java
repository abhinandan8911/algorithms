package org.abhi.algo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SubsetsTest {

    final Integer[] ints = {-2, 1, -3, 4, -1, 2, 1, -5};
    final Integer[] contiguousInts = {4 , -1 , 2 , 1};
    final Integer[] improvedSubset = {-2 , 1 , -3 , 4};

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
}