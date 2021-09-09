package arrays.strings;

import utils.Printer;

/**
 * To many cycle to reach space O(1)
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {

//        int[][] input = new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] input = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//        int[][] input = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int[][] input = new int[][]{{1, 0}};
//        int[][] input = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        Printer.printMatrix(input);
        System.out.println();

        boolean isFirstColWithZeroes = false;
        boolean isFirstRolWithZeroes = false;

        for (int i = 0; i < input[0].length; i++) {
            System.out.println(input[0][i]);
            if (input[0][i] == 0) isFirstRolWithZeroes = true;
        }

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i][0]);
            if (input[i][0] == 0) isFirstColWithZeroes = true;
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 0) {
                    input[i][0] = 0;
                    input[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                if (input[i][0] == 0 || input[0][j] == 0) {
                    input[i][j] = 0;
                }
            }
        }

        Printer.printMatrix(input);
        System.out.println();

        if(isFirstRolWithZeroes){
            for (int i = 0; i < input[0].length; i++) {
                input[0][i] = 0;
            }
        }

        if(isFirstColWithZeroes){
            for (int i = 0; i < input.length; i++) {
                input[i][0] = 0;
            }
        }




        Printer.printMatrix(input);
        System.out.println();

    }
}
