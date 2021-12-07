package maze.project;

/**
 * Cell class stores data about the individual cells of a maze
 * 
 * @author Andrew Estes
 */
public class Cell {
    boolean visited = false; // for the maze creation aglorithm
    boolean traversed = false; // For the solving algorithm
    boolean hasNorthWall = true;
    boolean hasEastWall = true;
    boolean hasSouthWall = true;
    boolean hasWestWall = true;
    int x;
    int y;

    Cell() {
    }

    Cell(int x, int y, boolean visited) {
        this.x = x;
        this.y = y;
        this.visited = visited;
    }

    public String toString() {
        String string = "[" + x + ", " + y + "], ";

        return string;
    }
}
