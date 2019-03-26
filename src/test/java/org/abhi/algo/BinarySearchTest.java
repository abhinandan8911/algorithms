package org.abhi.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private Integer[] integers = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    @Test
    public void binarySearch() {
        assertTrue(BinarySearch.binarySearch(5, integers));
        assertFalse(BinarySearch.binarySearch(11, integers));
    }
}