package arrays.strings;

import utils.Printer;

public class RotateImage {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 2, 3, 4, 5}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14}, {15, 16, 17, 18, 19},{15, 16, 17, 18, 19}};

//        int[][] input = new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};

//        int[][] input = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

//        int[][] input = new int[][]{{1, 2}, {4, 5}};

//        int[][] input = new int[][]{{1}};

        Printer.printMatrix(input);
        System.out.println();

        int l = input.length;
        int iterationCount = l / 2;

        int startI = 0;
        int startJ = 0;

        int i = 0;
        int j = 0;

        int newI = -1;
        int newJ = -1;

        while (iterationCount > 0) {

            while (startJ != l - startI - 1) {

                int tmp = input[startI][startJ];

                while (true) {

                    newI = l - (l - j);
                    newJ = l -1 - i;

                    System.out.printf("(%s,%s) -> (%s, %s)", i, j, newI, newJ);
                    System.out.println();

                    int prev = tmp;
                    tmp = input[newI][newJ];
                    input[newI][newJ] = prev;

                    i = newI;
                    j = newJ;

                    if (i == startI && j == startJ) break;
                }
                System.out.println();
                j++;
                startJ++;
            }
            startI++;
            startJ = startI;
            i = startI;
            j = startJ;

            iterationCount--;
        }

        Printer.printMatrix(input);

//
//        while (iterationCount >= 0) {
//
//            for (int k = iterationCount; k >= 0; k--) {
//                int tmp = input[i][j];
//
//                for (int n = elementsCount; n >= 0; n--) {
//                    int newI = l - (l - j);
//                    int newJ = l - i;
//
//                    System.out.printf("(%s,%s) -> (%s, %s)", i, j, newI, newJ);
//                    System.out.println();
//
//                    int prev = tmp;
//                    tmp = input[newI][newJ];
//                    input[newI][newJ] = prev;
//
//                    i = newI;
//                    j = newJ;
//
//                }
//                System.out.println();
//                MatrixPrinter.printMatrix(input);
//                System.out.println();
//                j++;
//            }
//            i = startI + 1;
//            j = startJ + 1;
//            rotationCount--;
//            elementsCount -= 2;
//            iterationCount--;
//        }
//        System.out.println();
//        MatrixPrinter.printMatrix(input);
//        System.out.println();


    }


}
