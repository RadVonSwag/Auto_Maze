package com.radvonswag.automaze.service;

import com.radvonswag.automaze.model.Cell;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

/**
 * MazeMaker makes the maze and includes a solve function to solve the maze
 * 
 * @author Andrew Estes
 */
public class MazeMaker {

    public int dimensions;
    public Cell[][] CELL_MATRIX;
    Random random = new Random();

    public MazeMaker(int dimensions) {
        this.dimensions = dimensions;
    }

    public void createMazeWalls() {
        Stack<Cell> PATH = new Stack<>();
        Stack<String> DIRECTIONS = new Stack<>();
        CELL_MATRIX = new Cell[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                CELL_MATRIX[i][j] = new Cell(i, j, false);
            }
        }
        CELL_MATRIX[0][0].setVisited(true);
        PATH.push(CELL_MATRIX[0][0]);
        int visitedCount = 1;

        while (visitedCount < dimensions * dimensions) {
            // Set of unvisited neighbors
            ArrayList<Integer> neighbors = new ArrayList<>();
            Cell currentCell = PATH.peek();
            int xCoord = currentCell.getX();
            int yCoord = currentCell.getY();

            // Check for North neighbors
            if ((yCoord - 1 != -1) && !CELL_MATRIX[xCoord][yCoord - 1].isVisited()) {
                neighbors.add(0);
            }
            // Check for East neighbors
            if ((xCoord + 1 < dimensions) && !CELL_MATRIX[xCoord + 1][yCoord].isVisited()) {
                neighbors.add(1);
            }
            // Check for South neighbors
            if ((yCoord + 1 < dimensions) && !CELL_MATRIX[xCoord][yCoord + 1].isVisited()) {
                neighbors.add(2);
            }
            // Check for West neighbors
            if ((xCoord - 1 != -1) && !CELL_MATRIX[xCoord - 1][yCoord].isVisited()) {
                neighbors.add(3);
            }

            // Check for no available neighbors
            if (!neighbors.isEmpty()) {
                // Randomly choose next neighbor
                int nextDirection = random.nextInt(neighbors.size());
                nextDirection = neighbors.get(nextDirection);
                switch (nextDirection) {
                    case 0: // North
                        CELL_MATRIX[xCoord][yCoord - 1].setVisited(true);
                        currentCell.setHasNorthWall(false);
                        CELL_MATRIX[xCoord][yCoord - 1].setHasSouthWall(false);
                        currentCell = CELL_MATRIX[xCoord][yCoord - 1];
                        PATH.push(currentCell);
                        DIRECTIONS.push("N");
                        break;
                    case 1: // East
                        CELL_MATRIX[xCoord + 1][yCoord].setVisited(true);
                        currentCell.setHasEastWall(false);
                        ;
                        CELL_MATRIX[xCoord + 1][yCoord].setHasWestWall(false);
                        currentCell = CELL_MATRIX[xCoord + 1][yCoord];
                        PATH.push(currentCell);
                        DIRECTIONS.push("E");
                        break;
                    case 2: // South
                        CELL_MATRIX[xCoord][yCoord + 1].setVisited(true);
                        currentCell.setHasSouthWall(false);
                        CELL_MATRIX[xCoord][yCoord + 1].setHasNorthWall(false);
                        currentCell = CELL_MATRIX[xCoord][yCoord + 1];
                        PATH.push(currentCell);
                        DIRECTIONS.push("S");
                        break;
                    case 3: // West
                        CELL_MATRIX[xCoord - 1][yCoord].setVisited(true);
                        currentCell.setHasWestWall(false);
                        CELL_MATRIX[xCoord - 1][yCoord].setHasEastWall(false);
                        currentCell = CELL_MATRIX[xCoord - 1][yCoord];
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
        CELL_MATRIX[0][0].setHasWestWall(false);
        CELL_MATRIX[dimensions - 1][dimensions - 1].setHasEastWall(false);
    }

    /**
     * Solves the maze and returns the path in a LinkedList
     * 
     * @return
     */
    public LinkedList<Integer> solveMaze() {
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
        Stack<Cell> cellStack = new Stack<>();

        LinkedList<Integer> solvedPath = new LinkedList<Integer>();

        while (currentCell != CELL_MATRIX[dimensions - 1][dimensions - 1]) {
            cellStack.add(currentCell);

            canMoveNorth = false;
            canMoveEast = false;
            canMoveSouth = false;
            canMoveWest = false;

            int xCoord = currentCell.getX();
            int yCoord = currentCell.getY();

            if (currentCell == CELL_MATRIX[dimensions - 1][dimensions - 1]) {
                currentCell.setTraversed(true);
                break;
            }

            if (!currentCell.hasNorthWall()) {
                canMoveNorth = true;
                northCell = CELL_MATRIX[xCoord][yCoord - 1];
            }
            if ((!currentCell.hasEastWall()) && (currentCell != CELL_MATRIX[dimensions - 1][dimensions - 1])) {
                canMoveEast = true;
                eastCell = CELL_MATRIX[xCoord + 1][yCoord];
            }
            if (!currentCell.hasSouthWall()) {
                canMoveSouth = true;
                southCell = CELL_MATRIX[xCoord][yCoord + 1];
            }
            if ((!currentCell.hasWestWall()) && (currentCell != CELL_MATRIX[0][0])) {
                canMoveWest = true;
                westCell = CELL_MATRIX[xCoord - 1][yCoord];
            }

            if ((canMoveNorth) && (!northCell.isTraversed())) {
                currentCell.setTraversed(true);
                previousCell = (Cell) cellStack.peek();
                currentCell = northCell;
                solvedPath.add(0);
                continue;

            }
            if ((canMoveEast) && (!eastCell.isTraversed())) {
                currentCell.setTraversed(true);
                previousCell = (Cell) cellStack.peek();
                currentCell = eastCell;
                solvedPath.add(1);
                continue;

            }
            if ((canMoveSouth) && (!southCell.isTraversed())) {
                currentCell.setTraversed(true);
                previousCell = (Cell) cellStack.peek();
                currentCell = southCell;
                solvedPath.add(2);
                continue;

            }
            if ((canMoveWest) && (!westCell.isTraversed())) {
                currentCell.setTraversed(true);
                previousCell = (Cell) cellStack.peek();
                currentCell = westCell;
                solvedPath.add(3);
                continue;

            } else {
                solvedPath.removeLast();
                currentCell.setTraversed(true);
                cellStack.pop();
                currentCell = (Cell) cellStack.pop();
                continue;
            }
        }
        return solvedPath;
    }
}
