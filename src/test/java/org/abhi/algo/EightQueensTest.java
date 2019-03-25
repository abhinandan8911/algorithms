package org.abhi.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class EightQueensTest {


    @Test
    public void isValidRowColumn() {
        assertTrue(EightQueens.isValidPosition(5, 6));
        assertFalse(EightQueens.isValidPosition(10, 6));
    }

    @Test
    public void placeQueens() {
        EightQueens.placeQueens();
    }

}