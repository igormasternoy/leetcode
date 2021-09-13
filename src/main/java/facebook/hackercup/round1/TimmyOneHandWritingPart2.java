package facebook.hackercup.round1;

import utils.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Dynamic Programimng yeeehaaa
 */
public class TimmyOneHandWritingPart2 {

    public static void main(String[] args) throws IOException {
//        String test = "FXXFXFOOXF"; //"FFOFF" - 0 //"XFO" - 1;//"XOFXOX";
//        String test = "XOFXOX"; //24
//        String test = "XFO"; //1
//        String test = "XOXOXOXOXO"; //146
//        String test = "OFFX";
//        System.out.println(solveTaskBruteForce(test.length(), test));
//        System.out.println(solveTask(test.length(), test));
//
//        System.out.println(Long.MAX_VALUE);

        Path path = Paths.get(args[0]);

        BufferedReader reader = Files.newBufferedReader(path);

        int totalCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < totalCases; i++) {
            int stringLength = Integer.parseInt(reader.readLine());
            String exercise = reader.readLine();
//            long totalSum = solveTaskBruteForce(stringLength,exercise); //solveTask(stringLength,exercise);
            long totalSum = solveTask(stringLength,exercise);
            System.out.printf("Case #%s: %s\n", i+1, totalSum % 1000000007);
//            System.out.printf("Case #%s: %s\n", i+1, totalSum);
        }

    }

    private static long solveTaskBruteForce(int stringLength, String exercise) {
        long[][] dp = new long[stringLength][stringLength];
        long totalSum = 0;

        for (int i = 0; i < stringLength - 1; i++) {
            for (int j = i; j < stringLength; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }


                String substring = exercise.substring(i,j+1);
//                System.out.printf("%s\n",substring);
                long switches = countSwitches(substring);
                totalSum += switches;

            }
        }
        return totalSum;
    }

    private static long solveTask(int stringLength, String exercise) {
        long[][] dp = new long[stringLength][stringLength];

        long totalSum = 0;
        //Prepare dp matrix
        for (int i = 0; i < stringLength - 1; i++) {
            for (int j = i; j < i + 3; j++) {
                if (j == stringLength) break;

                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }

                String substring = exercise.substring(i,j+1);
                long switches = countSwitches(substring);
                totalSum += switches;
                dp[i][j] = switches;
//                System.out.println(substring);
            }
        }
//        Printer.printMatrix(dp);

        int leftDiagonals = stringLength - 3;
        if (leftDiagonals <= 0) {
//            System.out.println("Total sum: " + totalSum);
            return totalSum;
        }


        for (int diagonal = stringLength - leftDiagonals; diagonal < stringLength; diagonal++) {

            for (int i = 0; i < stringLength - diagonal; i++) {
                int j = i + diagonal;

//                System.out.printf("%s %s \n", i, j);

                dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                totalSum += dp[i][j];
            }

        }

//        Printer.printMatrix(dp);

//        System.out.println("Total sum: " + totalSum);
        return totalSum;
    }


    private static long countSwitches(String exercise) {
        long switches = 0;
        String hand = null; //"left"; //right

        for (int i = 0; i < exercise.length(); i++) {
            char letter = exercise.charAt(i);

            if (letter == 'F') {
                continue;
            }

            if (letter == 'X') {
                if (hand == null) {
                    hand = "left";
                } else if (hand == "right") {
                    switches++;
                    hand = "left";
                }
                continue;
            }

            if (letter == 'O') {
                if (hand == null) {
                    hand = "right";
                } else if (hand == "left") {
                    switches++;
                    hand = "right";
                }
                continue;
            }
        }
//        System.out.printf("Case #%s %s: %s\n", caseNum, exercise, switches);
//        System.out.printf("Case #%s: %s\n", caseNum + 1, switches);
        return switches;
    }
}
