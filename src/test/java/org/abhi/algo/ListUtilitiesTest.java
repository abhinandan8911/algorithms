package org.abhi.algo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListUtilitiesTest {

    List<Integer> list;
    final Integer[] ascendingOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final Integer[] descendingOrder = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    final int difference = 5;

    @Before
    public void setUp() throws Exception {
        list = Arrays.asList(10, 7, 6, 9, 4, 3, 1, 2, 5, 8);
    }

    @Test
    public void sortedList() {
        assertTrue(assertInGivenOrder(ListUtilities.sortedList(list, true), ascendingOrder));
        assertTrue(assertInGivenOrder(ListUtilities.sortedList(list, false), descendingOrder));
    }

    @Test
    public void absIntegerDifference() {
        assertEquals(difference, ListUtilities.absIntegerDifference(new Integer(5), new Integer(0)));
        assertEquals(difference, ListUtilities.absIntegerDifference(new Integer(0), new Integer(5)));
    }

    @Test
    public void copyList() {
        List<Integer> newList = ListUtilities.copyList(list);
        assertFalse(newList == list);
    }

    @Test
    public void getSumFromIntegerSet() {
        assertEquals(55, ListUtilities.getSumFromIntegerSet(list).intValue());
    }

    public <T> boolean assertInGivenOrder(List<T> listOfTs, T... ts) {
        if(listOfTs.size() != ts.length ) {
            return false;
        }
        boolean isInOrder = true;
        for (int i = 0; i < listOfTs.size(); i++) {
            if(listOfTs.get(i) != ts[i]) {
                isInOrder = false;
                break;
            }
        }
        return isInOrder;
    }
}