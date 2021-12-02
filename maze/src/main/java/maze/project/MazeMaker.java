package maze.project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

    public int dimensions;
    private int visitedCount;
    public Cell[][] CELL_MATRIX;
    Random random = new Random();
    public LinkedList<Integer> solvePath = new LinkedList<Integer>();

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
                nextDirection = neighbors.get(nextDirection);
                if (CELL_MATRIX[dimensions-1][dimensions-1].visited == false)
                {
                    solvePath.add(nextDirection);
                }
                switch (nextDirection) {
                    case 0: // North
                        CELL_MATRIX[currentCell.x][currentCell.y - 1].visited = true;
                        currentCell.hasNorthWall = false;
                        CELL_MATRIX[currentCell.x][currentCell.y - 1].hasSouthWall = false;
                        currentCell = CELL_MATRIX[currentCell.x][currentCell.y - 1];
                        PATH.push(currentCell);
                        DIRECTIONS.push("N");
                        break;
                    case 1: // East
                        CELL_MATRIX[currentCell.x + 1][currentCell.y].visited = true;
                        currentCell.hasEastWall = false;
                        CELL_MATRIX[currentCell.x + 1][currentCell.y].hasWestWall = false;
                        currentCell = CELL_MATRIX[currentCell.x + 1][currentCell.y];
                        PATH.push(currentCell);
                        DIRECTIONS.push("E");
                        break;
                    case 2: // South
                        CELL_MATRIX[currentCell.x][currentCell.y + 1].visited = true;
                        currentCell.hasSouthWall = false;
                        CELL_MATRIX[currentCell.x][currentCell.y + 1].hasNorthWall = false;
                        currentCell = CELL_MATRIX[currentCell.x][currentCell.y + 1];
                        PATH.push(currentCell);
                        DIRECTIONS.push("S");
                        break;
                    case 3: // West
                        CELL_MATRIX[currentCell.x - 1][currentCell.y].visited = true;
                        currentCell.hasWestWall = false;
                        CELL_MATRIX[currentCell.x - 1][currentCell.y].hasEastWall = false;
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

        // To create openings in the maze at the end and beginning
        CELL_MATRIX[0][0].hasWestWall = false;
        CELL_MATRIX[dimensions - 1][dimensions - 1].hasEastWall = false;

        Stack reversePath = new Stack();
        while (!PATH.isEmpty()) {
            reversePath.add(PATH.pop());
        }


        System.out.println("\n");
        Stack reverseDirections = new Stack();
        while (!DIRECTIONS.isEmpty()) {
            reverseDirections.add(DIRECTIONS.pop());
        }
        while (!reverseDirections.isEmpty()) {
            String toPrint2 = (String) reverseDirections.pop();
            System.out.printf(toPrint2);
        }

    }
/**
 * Solves the maze and returns the path in a LinkedList
 * @return
 */
    public LinkedList getSolvedPath() {
 
        

        return solvePath;
    }


    private void tempCode()
    {
        Cell currentCell = CELL_MATRIX[0][0];
        while (currentCell != CELL_MATRIX[dimensions -1][dimensions-1]) {
                ArrayList<Integer> nextSteps = new ArrayList<Integer>();
                //Can move north
                if (currentCell.hasNorthWall == false);
                {
                    nextSteps.add(0);
                }
                //Can move east
                if (currentCell.hasEastWall == false)
                {
                    nextSteps.add(1);
                }
                //Can move south
                if (currentCell.hasSouthWall == false)
                {
                    nextSteps.add(2);
                }
                //Can move west
                if (currentCell.hasSouthWall == false)
                {
                    nextSteps.add(3);
                }

                int nextStep = random.nextInt(nextSteps.size());


            }
    }

}
