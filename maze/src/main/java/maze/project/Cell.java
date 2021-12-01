package maze.project;

public class Cell {
    boolean visited = false;
    boolean hasNorthWall = true;
    boolean hasEastWall = true;
    boolean hasSouthWall = true;
    boolean hasWestWall = true;
    int x;
    int y;

    
    Cell()
    {}
    
    Cell(int x, int y, boolean visited)
    {
        this.x = x;
        this.y = y;
        this.visited = visited;
    }

    public String toString()
    {
        String string = "[" + x +", " + y + "], ";

        return string;
    }

}
