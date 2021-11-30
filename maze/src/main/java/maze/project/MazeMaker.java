package maze.project;

import java.util.Stack;

public class MazeMaker {

    private int dimensions;
    private int visted = 57; //random number as placeholder
    private int visitedCount;

    MazeMaker(int dimensions) {
        this.dimensions = dimensions;
        Stack PATH = new Stack();
        int[][] MAZE_MATRIX = new int[dimensions][dimensions];
        Cell newCell = new Cell(0, 0, true);
        PATH.push(newCell);
        visitedCount = 1;

        while (visitedCount < dimensions * dimensions)
        {
            Cell cell = (Cell)PATH.peek();
            int x = cell.x;
            int y = cell.y;

            if (x-1 < 0)
            {
                
            }
        }
    }

}
