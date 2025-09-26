package com.radvonswag.automaze.service;

import com.radvonswag.automaze.model.Cell;

import java.util.LinkedList;
import java.util.Random;

/*
Never got the recursive approach working, but keeping this here for now.
 */
public class MazeMakerRecursive {

    public int dimensions;
    public Cell[][] CELL_MATRIX;
    Random random = new Random();

    private LinkedList<Integer> recursiveSolveAttempt(Cell currentCell, Cell previousCell) {
        boolean canMoveNorth = false;
        boolean canMoveEast = false;
        boolean canMoveSouth = false;
        boolean canMoveWest = false;
        Cell northCell = new Cell();
        Cell eastCell = new Cell();
        Cell southCell = new Cell();
        Cell westCell = new Cell();

        int xCoord = currentCell.getX();
        int yCoord = currentCell.getY();

        LinkedList<Integer> solvedPath = new LinkedList<Integer>();

        if (currentCell == CELL_MATRIX[dimensions - 1][dimensions - 1]) {
            currentCell.setTraversed(true);
            return solvedPath;
        }

        if (currentCell.hasNorthWall() == false) {
            canMoveNorth = true;
            northCell = CELL_MATRIX[xCoord][yCoord - 1];
        }
        if ((currentCell.hasEastWall() == false) && (currentCell != CELL_MATRIX[dimensions - 1][dimensions - 1])) {
            canMoveEast = true;
            eastCell = CELL_MATRIX[xCoord + 1][yCoord];
        }
        if (currentCell.hasSouthWall() == false) {
            canMoveSouth = true;
            southCell = CELL_MATRIX[xCoord][yCoord + 1];
        }
        if ((currentCell.hasWestWall() == false) && (currentCell != CELL_MATRIX[0][0])) {
            canMoveWest = true;
            westCell = CELL_MATRIX[xCoord - 1][yCoord];
        }

        if ((canMoveNorth == true) && (northCell.isTraversed() == false)) {
            currentCell.setTraversed(true);
            previousCell = currentCell;
            currentCell = northCell;
            solvedPath.add(0);
            solve(currentCell, previousCell);
        }
        if ((canMoveEast == true) && (eastCell.isTraversed() == false)) {
            currentCell.setTraversed(true);
            previousCell = currentCell;
            currentCell = eastCell;
            solvedPath.add(1);
            solve(currentCell, previousCell);
        }
        if ((canMoveSouth == true) && (southCell.isTraversed() == false)) {
            currentCell.setTraversed(true);
            previousCell = currentCell;
            currentCell = southCell;
            solvedPath.add(2);
            solve(currentCell, previousCell);
        }
        if ((canMoveWest == true) && (westCell.isTraversed() == false)) {
            currentCell.setTraversed(true);
            previousCell = currentCell;
            currentCell = westCell;
            solvedPath.add(3);
            solve(currentCell, previousCell);
        } else if (CELL_MATRIX[dimensions - 1][dimensions - 1].isTraversed() == true) {
            return solvedPath;
        } else {
            currentCell.setTraversed(true);
            solvedPath.removeLast();
            currentCell = previousCell;
            return solvedPath;
        }
        return solvedPath;
    }

    private void solve(Cell currentCell, Cell previousCell) {
        // Nothing here
    }

}
