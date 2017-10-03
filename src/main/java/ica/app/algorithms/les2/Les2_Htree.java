package ica.app.algorithms.les2;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/**
 * Created by Tim on 7-9-2017.
 */
public class Les2_Htree extends Applet {
    // reads an integer command-line argument n and plots an order n H-tree
    public static void main(String[] args) {
        JFrame jp1 = new JFrame();
        Les2_Htree a = new Les2_Htree();
        jp1.getContentPane().add(a, BorderLayout.CENTER);
        jp1.setSize(new Dimension(500, 500));
        jp1.setVisible(true);
    }

    public void paint(Graphics g) {
        int n = 5;

        int x = 250, y = 250;   // center of H-tree
        int size = 250;         // side length of H-tree
        draw(g, n, x, y, size);
    }

    // plot an H, centered on (x, y) of the given side length
    public static void drawH(Graphics g, int x, int y, int size) {

        // compute the coordinates of the 4 tips of the H
        int x0 = x - size / 2;
        int x1 = x + size / 2;
        int y0 = y - size / 2;
        int y1 = y + size / 2;

        // draw the 3 line segments of the H
        g.drawLine(x0, y0, x0, y1);    // left  vertical segment of the H
        g.drawLine(x1, y0, x1, y1);    // right vertical segment of the H
        g.drawLine(x0, y, x1, y);    // connect the two vertical segments of the H
    }

    // plot an order n H-tree, centered on (x, y) of the given side length
    public static void draw(Graphics g, int n, int x, int y, int size) {
        if (n == 0) return;
        drawH(g, x, y, size);

        // compute x- and y-coordinates of the 4 half-size H-trees
        int x0 = x - size / 2;
        int x1 = x + size / 2;
        int y0 = y - size / 2;
        int y1 = y + size / 2;

        // recursively draw 4 half-size H-trees of order n-1
        draw(g, n - 1, x0, y0, size / 2);    // lower left  H-tree
        draw(g, n - 1, x0, y1, size / 2);    // upper left  H-tree
        draw(g, n - 1, x1, y0, size / 2);    // lower right H-tree
        draw(g, n - 1, x1, y1, size / 2);    // upper right H-tree
    }
}
