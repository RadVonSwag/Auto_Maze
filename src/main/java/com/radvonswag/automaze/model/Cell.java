package com.radvonswag.automaze.model;

/**
 * Cell class stores data about the individual cells of a maze
 * 
 * @author Andrew Estes
 */
public class Cell {
    private boolean visited = false; // for the maze creation aglorithm
    private boolean traversed = false; // For the solving algorithm
    private boolean hasNorthWall = true;
    private boolean hasEastWall = true;
    private boolean hasSouthWall = true;
    private boolean hasWestWall = true;
    private int x;
    private int y;

    public Cell() {
    }

    public Cell(int x, int y, boolean visited) {
        this.x = x;
        this.y = y;
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isTraversed() {
        return traversed;
    }

    public void setTraversed(boolean traversed) {
        this.traversed = traversed;
    }

    public boolean hasNorthWall() {
        return hasNorthWall;
    }

    public void setHasNorthWall(boolean hasNorthWall) {
        this.hasNorthWall = hasNorthWall;
    }

    public boolean hasEastWall() {
        return hasEastWall;
    }

    public void setHasEastWall(boolean hasEastWall) {
        this.hasEastWall = hasEastWall;
    }

    public boolean hasSouthWall() {
        return hasSouthWall;
    }

    public void setHasSouthWall(boolean hasSouthWall) {
        this.hasSouthWall = hasSouthWall;
    }

    public boolean hasWestWall() {
        return hasWestWall;
    }

    public void setHasWestWall(boolean hasWestWall) {
        this.hasWestWall = hasWestWall;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        String string = "[" + x + ", " + y + "], ";
        return string;
    }
}
