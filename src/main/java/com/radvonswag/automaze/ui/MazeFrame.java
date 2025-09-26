package com.radvonswag.automaze.ui;

import com.radvonswag.automaze.model.Cell;
import com.radvonswag.automaze.service.MazeMaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.LinkedList;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Andrew
 */
public class MazeFrame extends javax.swing.JFrame {

    /**
     * Creates new form MazeFrame
     */
    public MazeFrame() {
        this.setVisible(true);
        this.setTitle("Andrew's Maze Generator");
        initComponents();
        g = mazeWindow.getGraphics();
        mazeWindow.paintComponents(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldDimensions = new javax.swing.JTextField();
        labelDim = new javax.swing.JLabel();
        buttonGenerate = new javax.swing.JButton();
        labelBGCol = new javax.swing.JLabel();
        labelWallCol = new javax.swing.JLabel();
        labelPathCol = new javax.swing.JLabel();
        mazeWindow = new javax.swing.JPanel();
        colorChooserBG = new javax.swing.JButton();
        colorChooserWall = new javax.swing.JButton();
        colorChooserPath = new javax.swing.JButton();
        buttonSolve = new javax.swing.JButton();
        colorSampleBg = new javax.swing.JPanel();
        colorSamplePath = new javax.swing.JPanel();
        colorSampleWall = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        fieldDimensions.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldDimensions.setText("30");
        fieldDimensions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDimensionsActionPerformed(evt);
            }
        });

        labelDim.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDim.setText("Maze Dimensions");

        buttonGenerate.setText("Generate Maze");
        buttonGenerate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

        labelBGCol.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelBGCol.setText("Background Color");

        labelWallCol.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelWallCol.setText("Maze Wall Color");

        labelPathCol.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelPathCol.setText("Path Color");

        mazeWindow.setBackground(new java.awt.Color(255, 255, 255));
        mazeWindow.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mazeWindow.setMaximumSize(new java.awt.Dimension(800, 800));
        mazeWindow.setPreferredSize(new java.awt.Dimension(800, 800));

        javax.swing.GroupLayout mazeWindowLayout = new javax.swing.GroupLayout(mazeWindow);
        mazeWindow.setLayout(mazeWindowLayout);
        mazeWindowLayout.setHorizontalGroup(
            mazeWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        mazeWindowLayout.setVerticalGroup(
            mazeWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        colorChooserBG.setText("Choose Color");
        colorChooserBG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorChooserBG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorChooserBGActionPerformed(evt);
            }
        });

        colorChooserWall.setText("Choose Color");
        colorChooserWall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorChooserWall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorChooserWallActionPerformed(evt);
            }
        });

        colorChooserPath.setText("Choose Color");
        colorChooserPath.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorChooserPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorChooserPathActionPerformed(evt);
            }
        });

        buttonSolve.setText("Solve Maze");
        buttonSolve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSolveActionPerformed(evt);
            }
        });

        colorSampleBg.setBackground(new java.awt.Color(255, 255, 255));
        colorSampleBg.setPreferredSize(new java.awt.Dimension(23, 23));

        javax.swing.GroupLayout colorSampleBgLayout = new javax.swing.GroupLayout(colorSampleBg);
        colorSampleBg.setLayout(colorSampleBgLayout);
        colorSampleBgLayout.setHorizontalGroup(
            colorSampleBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        colorSampleBgLayout.setVerticalGroup(
            colorSampleBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        colorSamplePath.setBackground(new java.awt.Color(0, 0, 255));
        colorSamplePath.setPreferredSize(new java.awt.Dimension(23, 23));

        javax.swing.GroupLayout colorSamplePathLayout = new javax.swing.GroupLayout(colorSamplePath);
        colorSamplePath.setLayout(colorSamplePathLayout);
        colorSamplePathLayout.setHorizontalGroup(
            colorSamplePathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        colorSamplePathLayout.setVerticalGroup(
            colorSamplePathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        colorSampleWall.setBackground(new java.awt.Color(255, 0, 0));
        colorSampleWall.setPreferredSize(new java.awt.Dimension(23, 23));

        javax.swing.GroupLayout colorSampleWallLayout = new javax.swing.GroupLayout(colorSampleWall);
        colorSampleWall.setLayout(colorSampleWallLayout);
        colorSampleWallLayout.setHorizontalGroup(
            colorSampleWallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        colorSampleWallLayout.setVerticalGroup(
            colorSampleWallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(mazeWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelBGCol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPathCol)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(colorChooserBG)
                        .addGap(18, 18, 18)
                        .addComponent(colorSampleBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelWallCol, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDim)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(colorChooserWall)
                        .addGap(18, 18, 18)
                        .addComponent(colorSampleWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(buttonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(colorChooserPath)
                            .addGap(18, 18, 18)
                            .addComponent(colorSamplePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(fieldDimensions, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(labelDim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldDimensions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelBGCol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(colorChooserBG)
                            .addComponent(colorSampleBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelWallCol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(colorChooserWall)
                            .addComponent(colorSampleWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPathCol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(colorChooserPath)
                            .addComponent(colorSamplePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)
                        .addComponent(buttonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(mazeWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldDimensionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDimensionsActionPerformed
        dimensions = Integer.parseInt(fieldDimensions.getText());
    }//GEN-LAST:event_fieldDimensionsActionPerformed

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        if (isInteger(fieldDimensions.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Please input a value between 1 and 30", "Error", 2);
            return;
        }
        dimensions = Integer.parseInt(fieldDimensions.getText());
        if (dimensions < 1 || dimensions > 30) {
            JOptionPane.showMessageDialog(null, "Please input a value between 1 and 30", "Error", 2);
            return;
        }
        maze = new MazeMaker(dimensions);
        maze.createMazeWalls();
        cell_matrix = maze.CELL_MATRIX;
        Graphics2D g2 = (Graphics2D) g;

        //Reset the canvas
        g2.setColor(bgColor);
        g2.fillRect(0, 0, 800, 800);

        //Draw the walls
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(wallColor);

        for (int i = 0; i < cell_matrix.length; i++) {
            for (int j = 0; j < cell_matrix.length; j++) {
                int x = cellSize + i * cellSize;
                int y = cellSize + j * cellSize;
                Cell currentCell = cell_matrix[i][j];

                // Has North Wall
                if (currentCell.hasNorthWall() == true) {
                    g2.drawLine(x, y, x + cellSize, y);
                }
                // Has East Wall
                if (currentCell.hasEastWall() == true) {
                    g2.drawLine(x + cellSize, y, x + cellSize, y + cellSize);
                }

                // Has South Wall
                if (currentCell.hasSouthWall() == true) {
                    g2.drawLine(x, y + cellSize, x + cellSize, y + cellSize);
                }

                // Has West Wall
                if (currentCell.hasWestWall() == true) {
                    g2.drawLine(x, y, x, y + cellSize);
                }
            }
        }
    }//GEN-LAST:event_buttonGenerateActionPerformed

    //Checks if input string is an integer number.
    private boolean isInteger(String dim) {
        try {
            Integer.parseInt(dim);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void colorChooserBGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooserBGActionPerformed
        bgColor = JColorChooser.showDialog(this, "Choose a Color", bgColor);
        mazeWindow.setBackground(bgColor);
        colorSampleBg.setBackground(bgColor);
    }//GEN-LAST:event_colorChooserBGActionPerformed

    private void colorChooserWallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooserWallActionPerformed
        wallColor = JColorChooser.showDialog(this, "Choose a Color", wallColor);
        colorSampleWall.setBackground(wallColor);
    }//GEN-LAST:event_colorChooserWallActionPerformed

    private void colorChooserPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooserPathActionPerformed
        pathColor = JColorChooser.showDialog(this, "Choose a Color", pathColor);
        colorSamplePath.setBackground(pathColor);
    }//GEN-LAST:event_colorChooserPathActionPerformed

    private void buttonSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSolveActionPerformed

        //Draw the maze
        Graphics2D g2 = (Graphics2D) g;
        int xCoord = cellSize / 2 + cellSize;
        int yCoord = 40;
        Path2D.Double path = new Path2D.Double();
        path.moveTo(xCoord, yCoord);
        LinkedList<Integer> solvedPath = maze.solveMaze(); // solves maze at this step.
        g2.setColor(pathColor);
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
    }//GEN-LAST:event_buttonSolveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MazeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MazeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MazeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MazeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MazeFrame().setVisible(true);
            }
        });
    }

    private MazeMaker maze;
    private int dimensions;
    private Cell[][] cell_matrix;
    private Color bgColor = Color.WHITE;
    private Color wallColor = Color.RED;
    private Color pathColor = Color.BLUE;
    private int cellSize = 25;
    private Graphics g;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JButton buttonSolve;
    private javax.swing.JButton colorChooserBG;
    private javax.swing.JButton colorChooserPath;
    private javax.swing.JButton colorChooserWall;
    private javax.swing.JPanel colorSampleBg;
    private javax.swing.JPanel colorSamplePath;
    private javax.swing.JPanel colorSampleWall;
    private javax.swing.JTextField fieldDimensions;
    private javax.swing.JLabel labelBGCol;
    private javax.swing.JLabel labelDim;
    private javax.swing.JLabel labelPathCol;
    private javax.swing.JLabel labelWallCol;
    private javax.swing.JPanel mazeWindow;
    // End of variables declaration//GEN-END:variables
}
