package maze.project;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MazePrinter extends JFrame {

    MazePrinter() {
        JPanel panel = new JPanel();
        this.setVisible(true);
        this.setTitle("Random Maze Generator");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pan = new JPanel();
        pan.setBackground(Color.ORANGE);
        this.setContentPane(pan);
        
        
    }

    MazePrinter(Cell[][] maze, int dimensions)
    {

        JPanel panel = new JPanel();

        BufferedImage image = new BufferedImage(dimensions, dimensions, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.CYAN);
        graphics.fillRect(0,0, dimensions, dimensions);
        graphics.setColor(Color.BLACK);

        for (int i =0; i < dimensions; i++)
        {
            for (int j = 0; j < dimensions; j++)
            {
                Cell currentCell = maze[i][j];
                if (currentCell.hasNorthWall)
                {
                    graphics.drawLine(j * dimensions, i * dimensions , dimensions + j * dimensions, i * dimensions);
                }
            }
        }

        graphics.drawLine(300, 350, 300, 350);
        this.setVisible(true);
        this.setTitle("Random Maze Generator");
        this.setLayout(null);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.ORANGE);
        panel.paint(graphics);
        this.setContentPane(panel);


    }

}
