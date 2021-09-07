package arrays.strings;

import utils.MatrixPrinter;

/**
 *
 */
public class TrappingRainWaterBruteForce {

    public static void main(String[] args) {
        int[] input = new int[]{4, 2, 0, 3, 2, 5};
//        int[] input = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        int answer = 0;

        for (int i = 0; i < input.length; i++) {
            int leftMax = 0;
            int rigtMax = 0;

            for(int j = i-1; j>=0; j--){
                if (input[j] > leftMax ){
                    leftMax = Math.max(input[j], input[i]);
                }
            }

            for(int j = i+1; j<input.length; j++){
                if (input[j] > rigtMax ){
                    rigtMax = Math.max(input[j], input[i]);
                }
            }
            int res =  Math.min(leftMax, rigtMax) - input[i];
            answer +=  res > 0 ? res : 0;

        }

        System.out.println(answer);


    }
}
