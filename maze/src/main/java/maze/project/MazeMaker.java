package maze.project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

    private int dimensions;
    private int visitedCount;
    public Cell[][] CELL_MATRIX;
    Random random = new Random();

    MazeMaker(int dimensions) {
        this.dimensions = dimensions;
        Stack PATH = new Stack();
        Stack DIRECTIONS = new Stack();
        CELL_MATRIX = new Cell[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                CELL_MATRIX[i][j] = new Cell(i, j, false);
            }
        }
        CELL_MATRIX[0][0].visited = true;
        PATH.push(CELL_MATRIX[0][0]);
        visitedCount = 1;

        while (visitedCount < dimensions * dimensions) {
            // Set of unvisited neighbors
            ArrayList<Integer> neighbors = new ArrayList<>();
            Cell currentCell = (Cell) PATH.peek();

            // Check for North neighbors
            if ((currentCell.y - 1 != -1) && CELL_MATRIX[currentCell.x][currentCell.y - 1].visited == false) {
                neighbors.add(0);
            }
            // Check for East neighbors
            if ((currentCell.x + 1 < dimensions) && CELL_MATRIX[currentCell.x + 1][currentCell.y].visited == false) {
                neighbors.add(1);
            }
            // Check for South neighbors
            if ((currentCell.y + 1 < dimensions) && CELL_MATRIX[currentCell.x][currentCell.y + 1].visited == false) {
                neighbors.add(2);
            }
            // Check for West neighbors
            if ((currentCell.x - 1 != -1) && CELL_MATRIX[currentCell.x - 1][currentCell.y].visited == false) {
                neighbors.add(3);
            }

            // Check for no available neighbors
            if (!neighbors.isEmpty()) {
                // Randomly choose next neighbor
                int nextDirection = random.nextInt(neighbors.size());
                switch (neighbors.get(nextDirection)) {
                    case 0: // North
                        CELL_MATRIX[currentCell.x][currentCell.y - 1].visited = true;
                        currentCell.hasNorthWall = false;
                        currentCell = CELL_MATRIX[currentCell.x][currentCell.y - 1];
                        PATH.push(currentCell);
                        DIRECTIONS.push("N");
                        break;
                    case 1: // East
                        CELL_MATRIX[currentCell.x + 1][currentCell.y].visited = true;
                        currentCell.hasEastWall = false;
                        currentCell = CELL_MATRIX[currentCell.x + 1][currentCell.y];
                        PATH.push(currentCell);
                        DIRECTIONS.push("E");
                        break;
                    case 2: // South
                        CELL_MATRIX[currentCell.x][currentCell.y + 1].visited = true;
                        currentCell.hasSouthWall = false;
                        currentCell = CELL_MATRIX[currentCell.x][currentCell.y + 1];
                        PATH.push(currentCell);
                        DIRECTIONS.push("S");
                        break;
                    case 3: // West
                        CELL_MATRIX[currentCell.x - 1][currentCell.y].visited = true;
                        currentCell.hasSouthWall = false;
                        currentCell = CELL_MATRIX[currentCell.x - 1][currentCell.y];
                        PATH.push(currentCell);
                        DIRECTIONS.push("W");
                        break;
                }
                visitedCount++;
            } else {
                PATH.pop();
            }

        }

        Stack tempPath = new Stack();
        while (!PATH.isEmpty()) {
            tempPath.add(PATH.pop());
        }
        while (!tempPath.isEmpty()) {
            Cell toPrint = (Cell) tempPath.pop();
            System.out.printf(toPrint.toString());
        }
        
        System.out.println("\n");
        Stack tempDirections = new Stack();
        while (!DIRECTIONS.isEmpty())
        {
            tempDirections.add(DIRECTIONS.pop());
        }
        while (!tempDirections.isEmpty()) {
            String toPrint2 = (String) tempDirections.pop();
            System.out.printf(toPrint2);
        }

    }

}
