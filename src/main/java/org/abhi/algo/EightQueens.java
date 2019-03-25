package org.abhi.algo;

public class EightQueens {

    private static final int[][] chessBoard = new int[8][8];

    public static boolean isOccupied(int row, int column) {
        if(isValidRowColumn(row, column)) {
            return chessBoard[row][column] == 1;
        }
        else {
            throw new IllegalStateException("Row or column out of bounds");
        }
    }

    public static boolean isValidRowColumn(int row, int column) {
        if(row > 7 || column > 7) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean isValidPosition(int row, int column) {
        if(!isValidRowColumn(row, column)) {
            return false;
        }
        else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if( (isOccupied(i, j) && !(i == row && j == column)) && (row ==i || column == j || (Math.abs(row - i) == Math.abs(column - j)))){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static boolean placeQueensHelper(int row, int column, int queensPlaced) {
        if(!isValidPosition(row, column)) {
            return false;
        }
        if(queensPlaced == 8) {
            return true;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(!isOccupied(i, j)) {
                    chessBoard[i][j] = 1;
                    if(placeQueensHelper(i, j, queensPlaced + 1)) {
                        return true;
                    }
                    else {
                        chessBoard[i][j] = 0;
                    }
                }
            }
        }
        return false;
    }

    public static void placeQueens() {
        if(placeQueensHelper(0,0, 0)) {
            showPlacement();
        }
        else {
            System.out.println("Queens were not placed successfully");
        }
    }

    public static void showPlacement() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(isOccupied(i,j)) {
                    System.out.println("The occupied position - row : " + i + " column : " + j);
                }
            }
        }
    }
}
