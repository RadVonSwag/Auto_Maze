package maze.project;

public class Cell {
    boolean visted;
    int[] walls = {1,1,1,1}; //North, South, East, West
    int x;
    int y;

    Cell(int x, int y, boolean visited)
    {
        this.x = x;
        this.y = y;
        this.visted = visited;
    }

}
