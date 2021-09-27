package trees.graphs;

import utils.Printer;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {

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
                    grid[i][j] = '0';
                    goThroughIsland(i, j, grid);
                    Printer.printMatrix(grid);
                }
            }
        }
        return islands;
    }

    static class Point{
        public int i;
        public int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static void goThroughIsland(int i, int j, char[][] grid) {
        Queue<Point> neighbors = new LinkedList<>();
        neighbors.add(new Point(i,j));

        while(!neighbors.isEmpty()) {
            Point cur = neighbors.poll();
            int startI = cur.i;
            int startJ = cur.j;

            if (startI - 1 >= 0 && grid[startI - 1][startJ] == '1') {
                neighbors.add(new Point(startI -1, startJ));
                grid[startI-1][startJ] = '0';
            }
            if (startI + 1 < grid.length && grid[startI + 1][startJ] == '1') {
                neighbors.add(new Point(startI +1, startJ));
                grid[startI+1][startJ] = '0';
            }

            if (startJ - 1 >= 0 && grid[startI][startJ - 1] == '1') {
                neighbors.add(new Point(startI, startJ-1));
                grid[startI][startJ-1] = '0';
            }

            if (startJ +1 < grid[0].length && grid[startI][startJ + 1] == '1') {
                neighbors.add(new Point(startI, startJ+1));
                grid[startI][startJ+1] = '0';
            }
        }

    }
}
