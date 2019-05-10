public class MazeSolver {

    // The edge of the maze
    final int END = 5;

    boolean solveMaze(int maze[][], int row, int column) {
        return  (row == END - 1 && column == END - 1) || ((row >= 0 && row < END && column >= 0 && column < END && maze[row][column] == 0)  && (solveMaze(maze, row + 1, column) || solveMaze(maze, row, column + 1)));
    }

    public static void main(String[] args) {
        MazeSolver m = new MazeSolver();
        // Initialize the maze
        int maze[][] = {
        { 0, 0, 0, 0, 1 },
        { 0, 1, 1, 1, 1 },
        { 0, 0, 0, 1, 1 },
        { 1, 1, 0, 1, 1 },
        { 1, 1, 0, 0, 0 } };

        // Start the maze solver.
        System.out.println(m.solveMaze(maze, 0, 0));
    }
}