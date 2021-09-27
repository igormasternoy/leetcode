package trees.graphs;

import utils.Printer;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    goThroughIsland(i, j, grid);
                    Printer.printMatrix(grid);
                }
            }
        }
        return islands;
    }

    private static void goThroughIsland(int startI, int startJ, char[][] grid) {
        if (startI < 0 || startI == grid.length) return;
        if (startJ < 0 || startJ == grid[startI].length) return;

        if (grid[startI][startJ] != '1') return;

        grid[startI][startJ] = '2';
        Printer.printMatrix(grid);
        goThroughIsland(startI+1, startJ, grid);
        goThroughIsland(startI, startJ+1, grid);
        goThroughIsland(startI-1, startJ, grid);
        goThroughIsland(startI, startJ-1, grid);

    }
}
