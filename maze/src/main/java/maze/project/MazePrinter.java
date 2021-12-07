package maze.project;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.LinkedList;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.BasicStroke;
import java.awt.geom.Path2D;

/**
 * MazePrinter is responsible for generating a window and displaying the maze
 * once it has been created and solved.
 * Unfortunately, due to time constraints and lack of familiarity with GUI
 * tools, It displays the maze and solved path at the same time
 * There are remnants of attempts to make GUI functions work. I may return to
 * this application and touch up the GUI.
 * 
 * @author Andrew Estes
 */
public class MazePrinter extends JFrame implements ActionListener {

    int x1;
    int x2;
    int y1;
    int y2;
    int cellSize = 25;
    Cell[][] cell_matrix;
    ImageIcon background;
    JLabel label;
    MazeMaker maze;
    JButton solveButton;

    MazePrinter(MazeMaker maze) {

        this.maze = maze;
        cell_matrix = maze.CELL_MATRIX;
        int dimensions = 1200;

        // background = new ImageIcon(this.getClass().getResource("background.jpg"));
        // label = new JLabel(background);
        // label.setSize(dimensions, dimensions);

        // this.add(label);
        this.setVisible(true);
        this.setTitle("Random Maze Generator - CS3354 - Created by Andrew Estes");
        this.setLayout(null);

        this.setSize(dimensions, dimensions);
        // this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setContentPane(panel);
        this.setBackground(Color.pink);

        solveButton = new JButton("Solve");
        solveButton.setBounds(100, 100, 800, 100);
        this.add(solveButton);
        solveButton.addActionListener(this);

    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.magenta);

        for (int i = 0; i < cell_matrix.length; i++) {
            for (int j = 0; j < cell_matrix.length; j++) {
                int x = cellSize + i * cellSize;
                int y = cellSize + j * cellSize;
                Cell currentCell = cell_matrix[i][j];

                // Has North Wall
                if (currentCell.hasNorthWall == true) {
                    g2.drawLine(x, y, x + cellSize, y);
                }
                // Has East Wall
                if (currentCell.hasEastWall == true) {
                    g2.drawLine(x + cellSize, y, x + cellSize, y + cellSize);
                }

                // Has South Wall
                if (currentCell.hasSouthWall == true) {
                    g2.drawLine(x, y + cellSize, x + cellSize, y + cellSize);
                }

                // Has West Wall
                if (currentCell.hasWestWall == true) {
                    g2.drawLine(x, y, x, y + cellSize);
                }
            }
        }

        // Path drawing
        int xCoord = cellSize / 2 + cellSize;
        int yCoord = 40;
        Path2D.Double path = new Path2D.Double();
        path.moveTo(xCoord, yCoord);
        LinkedList<Integer> solvedPath = maze.getPath();
        g2.setColor(Color.red);
        for (int i = 0; i < solvedPath.size(); i++) {
            // North
            if (solvedPath.get(i) == 0) {
                yCoord = yCoord - 25;
                path.lineTo(xCoord, yCoord);
                g2.draw(path);
            }
            // East
            if (solvedPath.get(i) == 1) {
                xCoord = xCoord + 25;
                path.lineTo(xCoord, yCoord);
                g2.draw(path);
            }
            // South
            if (solvedPath.get(i) == 2) {
                yCoord = yCoord + 25;
                path.lineTo(xCoord, yCoord);
                g2.draw(path);
            }
            // West
            if (solvedPath.get(i) == 3) {
                xCoord = xCoord - 25;
                path.lineTo(xCoord, yCoord);
                g2.draw(path);
            }

        }
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
