package arrays.strings;

/**
 *
 */
public class TrappingRainWaterDP {

    public static void main(String[] args) {
        int[] input = new int[]{4, 2, 0, 3, 2, 5};
        int[] leftMax = new int[input.length];
        int[] rightMax = new int[input.length];

        int answer = 0;

        leftMax[0] = input[0];
        rightMax[input.length-1]=input[input.length-1];

        for (int i = 1; i < input.length; i++) {
            leftMax[i] = Math.max(input[i], leftMax[i-1]);
        }

        for (int i = input.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(input[i], rightMax[i+1]);
        }

        for(int i =0; i < input.length; i++){
            answer += Math.min(leftMax[i],rightMax[i]) - input[i];
        }

        System.out.println(answer);


    }
}
