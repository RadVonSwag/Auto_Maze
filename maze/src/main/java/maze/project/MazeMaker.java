package maze.project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

/**
 * MazeMaker makes the maze and includes a solve function to solve the maze
 */
public class MazeMaker {

    public int dimensions;
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
                nextDirection = neighbors.get(nextDirection);
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

    public LinkedList SolvePath() {
        solve();
        return solvedPath;
    }

    private LinkedList<Integer> solvedPath = new LinkedList<Integer>();

    /**
     * Solves the maze and returns the path in a LinkedList
     * 
     * @return
     */
    private LinkedList solve() {
        Cell currentCell = CELL_MATRIX[0][0];
        Cell previousCell = currentCell;
        boolean canMoveNorth;
        boolean canMoveEast;
        boolean canMoveSouth;
        boolean canMoveWest;
        Cell northCell = new Cell();
        Cell eastCell = new Cell();
        Cell southCell = new Cell();
        Cell westCell = new Cell();
        Stack cellStack = new Stack();

        while (currentCell != CELL_MATRIX[dimensions-1][dimensions-1])
        {
            cellStack.add(currentCell);

            canMoveNorth = false;
            canMoveEast = false;
            canMoveSouth = false;
            canMoveWest = false;

            if (currentCell == CELL_MATRIX[dimensions - 1][dimensions - 1]) {
                currentCell.traversed = true;
                break;
            }

            if (currentCell.hasNorthWall == false) {
                canMoveNorth = true;
                northCell = CELL_MATRIX[currentCell.x][currentCell.y - 1];
            }
            if ((currentCell.hasEastWall == false) && (currentCell != CELL_MATRIX[dimensions - 1][dimensions - 1])) {
                canMoveEast = true;
                eastCell = CELL_MATRIX[currentCell.x + 1][currentCell.y];
            }
            if (currentCell.hasSouthWall == false) {
                canMoveSouth = true;
                southCell = CELL_MATRIX[currentCell.x][currentCell.y + 1];
            }
            if ((currentCell.hasWestWall == false) && (currentCell != CELL_MATRIX[0][0])) {
                canMoveWest = true;
                westCell = CELL_MATRIX[currentCell.x - 1][currentCell.y];
            }

            if ((canMoveNorth == true) && (northCell.traversed == false)) {
                currentCell.traversed = true;
                previousCell = (Cell)cellStack.peek();
                currentCell = northCell;
                solvedPath.add(0);
                continue;
    
            }
            if ((canMoveEast == true) && (eastCell.traversed == false)) {
                currentCell.traversed = true;
                previousCell = (Cell)cellStack.peek();
                currentCell = eastCell;
                solvedPath.add(1);
                continue;
    
            }
            if ((canMoveSouth == true) && (southCell.traversed == false)) {
                currentCell.traversed = true;
                previousCell = (Cell)cellStack.peek();
                currentCell = southCell;
                solvedPath.add(2);
                continue;
    
            }
            if ((canMoveWest == true) && (westCell.traversed == false)) {
                currentCell.traversed = true;
                previousCell = (Cell)cellStack.peek();
                currentCell = westCell;
                solvedPath.add(3);
                continue;
    
            }
            else {
                solvedPath.removeLast();
                currentCell.traversed = true;
                cellStack.pop();
                currentCell = (Cell)cellStack.pop();
                continue;
            }
        }
        return solvedPath;
    }

    public LinkedList getPath() {
        return solvedPath;
    }


    /* private void tempCodeE(Cell currentCell, Cell previousCell)
    {
        boolean canMoveNorth = false;
        boolean canMoveEast = false;
        boolean canMoveSouth = false;
        boolean canMoveWest = false;
        Cell northCell = new Cell();
        Cell eastCell = new Cell();
        Cell southCell = new Cell();
        Cell westCell = new Cell();

        if (currentCell == CELL_MATRIX[dimensions - 1][dimensions - 1]) {
            currentCell.traversed = true;
            return solvedPath;
        }

        if (currentCell.hasNorthWall == false) {
            canMoveNorth = true;
            northCell = CELL_MATRIX[currentCell.x][currentCell.y - 1];
        }
        if ((currentCell.hasEastWall == false) && (currentCell != CELL_MATRIX[dimensions - 1][dimensions - 1])) {
            canMoveEast = true;
            eastCell = CELL_MATRIX[currentCell.x + 1][currentCell.y];
        }
        if (currentCell.hasSouthWall == false) {
            canMoveSouth = true;
            southCell = CELL_MATRIX[currentCell.x][currentCell.y + 1];
        }
        if ((currentCell.hasWestWall == false) && (currentCell != CELL_MATRIX[0][0])) {
            canMoveWest = true;
            westCell = CELL_MATRIX[currentCell.x - 1][currentCell.y];
        }

        if ((canMoveNorth == true) && (northCell.traversed == false)) {
            currentCell.traversed = true;
            previousCell = currentCell;
            currentCell = northCell;
            solvedPath.add(0);
            solve(currentCell, previousCell);

        }
        if ((canMoveEast == true) && (eastCell.traversed == false)) {
            currentCell.traversed = true;
            previousCell = currentCell;
            currentCell = eastCell;
            solvedPath.add(1);
            solve(currentCell, previousCell);

        }
        if ((canMoveSouth == true) && (southCell.traversed == false)) {
            currentCell.traversed = true;
            previousCell = currentCell;
            currentCell = southCell;
            solvedPath.add(2);
            solve(currentCell, previousCell);

        }
        if ((canMoveWest == true) && (westCell.traversed == false)) {
            currentCell.traversed = true;
            previousCell = currentCell;
            currentCell = westCell;
            solvedPath.add(3);
            solve(currentCell, previousCell);

        } else if (CELL_MATRIX[dimensions - 1][dimensions - 1].traversed == true) {
            return solvedPath;
        } else {
            currentCell.traversed = true;
            solvedPath.removeLast();
            currentCell = previousCell;
            return solvedPath;

        }
        return solvedPath;
    } */
}