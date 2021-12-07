package maze.project;

import java.io.IOException;

/**
 * Main class for CS3354 Maze Project
 * 
 * @author Andrew Estes
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // Maze Dimensions
        int dimensions = 32;

        // Create a new maze and print directional path
        MazeMaker maze = new MazeMaker(dimensions);
        MazePrinter printer = new MazePrinter(maze);
        maze.SolvePath();

    }
}
