package arrays.strings;

import utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 2, 3, 4, 5}, {5, 6, 7, 8, 9}, {0, 1, 2, 3, 4}, {3, 6, 7, 8, 9}, {5, 6, 7, 8, 9}};

//        int[][] input = new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};

//        int[][] input = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

//        int[][] input = new int[][]{{1, 2}, {4, 5}};

//        int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}};

//        int[][] input = new int[][]{{1}};

//        int[][] input = new int[][]{{3}, {2}, {4}};
//        int[][] input = new int[][]{{3, 2, 4}};


        Printer.printMatrix(input);


        int l = Math.min(input.length, input[0].length);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < l % 2 + l / 2; i++) {
            goToStart(i, i, input, result);

//            System.out.printf("(%s,%s)\n", i, i);


        }
        Printer.printList(result);


    }

    public static void goToStart(int startI, int startJ, int[][] matrix, List<Integer> result) {
        String state = "right";// down, left, up
        int i = startI;
        int j = startJ;

//        System.out.printf("%s, ", matrix[i][j]);
        result.add(matrix[i][j]);
        while (true) {


            if (state == "right") {
                j++;
                if (j > matrix[i].length - startI - 1) {
                    j--;
                    state = "down";
                } else if (j >= matrix[i].length - startI - 1) {
//                    System.out.printf("%s, ", matrix[i][j]);
                    result.add(matrix[i][j]);
                    state = "down";
                } else {
//                    System.out.printf("%s, ", matrix[i][j]);
                    result.add(matrix[i][j]);
                }
            } else if (state == "down") {
                i++;
                if (i > matrix.length - startJ - 1) {
                    i--;
                    state = "left";
                } else if (i >= matrix.length - startJ - 1) {
//                    System.out.printf("%s, ", matrix[i][j]);
                    result.add(matrix[i][j]);
                    state = "left";
                } else {
//                    System.out.printf("%s, ", matrix[i][j]);
                    result.add(matrix[i][j]);
                }
            } else if (state == "left") {
                j--;
                if (j < startJ || i == startI) {
                    j++;
                    state = "up";
                    break;
                } else if (j == startJ) {
//                    System.out.printf("%s, ", matrix[i][j]);
                    result.add(matrix[i][j]);
                    state = "up";
                } else {
//                    System.out.printf("%s, ", matrix[i][j]);
                    result.add(matrix[i][j]);
                }
            } else if (state == "up") {
                i--;
                if (i < startI) {
                    break;
                }
                if (i == startI) {
                    break;
                } else {
//                    System.out.printf("%s, ", matrix[i][j]);
                    result.add(matrix[i][j]);
                }
            }


        }


    }


}
