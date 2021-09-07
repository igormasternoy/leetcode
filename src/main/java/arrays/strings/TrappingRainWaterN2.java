package arrays.strings;

import utils.MatrixPrinter;

import java.util.Arrays;

/**
 *
 */
public class TrappingRainWaterN2 {

    public static void main(String[] args) {
        int[] input = new int[]{4, 2, 0, 3, 2, 5};
//        int[] input = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        int max = arrayMax(input);

        int[][] rainMatrix = new int[max][input.length];

        setupMatrix(input, rainMatrix);

        MatrixPrinter.printMatrix(rainMatrix);

        int totalWaterDrops = 0;
        String state = "no_wall"; // wall_found

        for (int i = 0; i < rainMatrix.length; i++) {
            state = "no_wall";
            int curWaterDropsCount = 0;
            for (int j = 0; j < rainMatrix[i].length; j++) {
//                System.out.println("(" + i + " , " + j + ") " + rainMatrix[i][j]);
                int curr = rainMatrix[i][j];

                if (curr == 1 && state == "no_wall") {
                    state = "wall_found";
                    continue;
                }

                if (curr == 1 && state == "wall_found") {
                    state = "wall_found";
                    totalWaterDrops+=curWaterDropsCount;
                    curWaterDropsCount=0;
                    continue;
                }

                if (curr == 0 && state == "wall_found") {
                    curWaterDropsCount++;
                    continue;
                }
            }
        }
        System.out.println(totalWaterDrops);


    }

    public static void setupMatrix(int[] inputArray, int[][] matrix) {
        for (int k = 0; k < inputArray.length; k++) {
            int input = inputArray[k];

            for (int i = 0; i < input; i++) {
                matrix[i][k] = 1;
            }

        }
    }

    public static int arrayMax(int[] input) {
        int curMax = Integer.MIN_VALUE;
        for (int el : input) {
            if (el > curMax) {
                curMax = el;
            }
        }
        return curMax;
    }
}
