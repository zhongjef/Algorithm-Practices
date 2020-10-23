package com.company;

import java.util.Arrays;
import java.util.Random;

class Solution {
    boolean checkFirstRow(int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col ++) {
            if (matrix[0][col] == 0) {
                return true;
            }
        }
        return false;
    }

    boolean checkFirstCol(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                return true;
            }
        }
        return false;
    }

    void zeroRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
    }

    void zeroCol(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

    void zeroMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        boolean firstRowZero = checkFirstRow(matrix);
        boolean firstColZero = checkFirstCol(matrix);
        for (int row = 1; row < M; row++) {
            for (int col = 1; col < N; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        for (int col = 1; col < N; col++) {
            if (matrix[0][col] == 0) zeroCol(matrix, col);
        }
        for (int row = 1; row < M; row++) {
            if (matrix[row][0] == 0) zeroRow(matrix, row);
        }
        if (firstColZero) zeroCol(matrix, 0);
        if (firstRowZero) zeroRow(matrix, 0);
    }

    String matToString(int[][] matrix) {
        StringBuilder out = new StringBuilder();
        for (int[] row : matrix) {
            out.append(Arrays.toString(row));
            out.append(System.lineSeparator());
        }
        out.append(System.lineSeparator());
        return out.toString();
    }
}

public class Main {


    public static void main(String[] args) {
	    Solution sol = new Solution();
	    int M = 6;
	    int N = 5;
	    int[][] matrix = new int[M][N];
	    for (int row = 0; row < M; row++) {
	        for (int col = 0; col < N; col++) {
	            matrix[row][col] = 1;
            }
        }
        Random random = new Random();
	    for (int n = 0; n < 5; n++) {
	        matrix[random.nextInt(M)][random.nextInt(N)] = 0;
        }
        System.out.println(sol.matToString(matrix));
	    sol.zeroMatrix(matrix);
        System.out.printf(sol.matToString(matrix));
    }
}
