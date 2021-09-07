package utils;

public class MatrixPrinter {

    public static void printMatrix(int[][] matrix){
        printMatrix(matrix,true);
    }

    public static void printMatrix(int[][] matrix, boolean newLine){
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        if(newLine) System.out.println();
    }
}
