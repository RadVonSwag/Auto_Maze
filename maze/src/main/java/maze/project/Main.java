package maze.project;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        //Maze Dimensions
        int dimensions = 4;

        System.out.println( "Balls, Man!!!" );
        
        //Create a new maze and print directional path
        MazeMaker maze = new MazeMaker(dimensions);

        MazePrinter printer = new MazePrinter(maze);
        
        System.out.println("\n\nMan Balls!!!");
    }
}
