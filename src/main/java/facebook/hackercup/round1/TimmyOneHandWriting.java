package facebook.hackercup.round1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TimmyOneHandWriting {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);

        BufferedReader reader = Files.newBufferedReader(path);

        int totalCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < totalCases; i++) {
            int stringLength = Integer.parseInt(reader.readLine());
            String exercise = reader.readLine();
            printExercise(i, stringLength, exercise);
        }

    }


    private static void printExercise(int caseNum, int stringLength, String exercise) {
        int switches = 0;
        String hand = null; //"left"; //right

        for (int i = 0; i < stringLength; i++) {
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
            }

            if (letter == 'O') {
                if (hand == null) {
                    hand = "right";
                } else if (hand == "left") {
                    switches++;
                    hand = "right";
                }
            }
        }
//        System.out.printf("Case #%s %s: %s\n", caseNum, exercise, switches);
        System.out.printf("Case #%s: %s\n", caseNum+1, switches);
    }
}
