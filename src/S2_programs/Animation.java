package S2_programs;

import Mathematical_Engine.M2;
import Mathematical_Engine.S2;
import Mathematical_Engine.V2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;

public class Animation extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new Animation();
        frame.setSize(700, 700);
        frame.setTitle("S2_programs.Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Animation() {
        add(new DrawPanel());
    }

    class DrawPanel extends JPanel {
        Timer myTimer = new Timer(50, new TimerListener());
        double textX = 0.5; // Initial x-coordinate of the text

        S2 S = new S2(50, 50, 100, 300);
        V2 A = new V2(0.5, 0.5);
        V2 B = new V2(0.5, 1.5);
        V2 C = new V2(9.5, 1.5);
        V2 D = new V2(9.5, 0.5);
        V2 Am = new V2(0, 0);
        V2 Bm = new V2(0, 2);
        V2 Cm = new V2(10, 2);
        V2 Dm = new V2(10, 0);

        double phi = PI / 100;

        M2 M = new M2(cos(phi), -sin(phi),
                sin(phi), cos(phi));

        double textScrollSpeed = 0.1;

        double x;

        boolean textVisible = true;

        String textFront = "";
        String textBehind = "";

        DrawPanel() {
            myTimer.start();
        }

        /*public void paintComponent(Graphics g) {
            super.paintComponent(g);

            String text = "Hello world";

            // Draw square
            S.drawLine(g, A, B);
            S.drawLine(g, B, C);
            S.drawLine(g, C, D);
            S.drawLine(g, D, A);
            S.drawLine(g, Am, Bm);
            S.drawLine(g, Bm, Cm);
            S.drawLine(g, Cm, Dm);
            S.drawLine(g, Dm, Am);

            // Calculate the boundaries of the square
            double minX = min(min(A.x, B.x), min(C.x, D.x));
            double maxX = max(max(A.x, B.x), max(C.x, D.x));

            // Check if any part of the text crosses the vertical boundaries of the square
            FontMetrics fm = g.getFontMetrics(new Font("Arial", Font.PLAIN, 65));
            int textWidth = fm.stringWidth(text)/100;
            if (x < textWidth) {
                x+=textWidth;
            }
            System.out.println("X = " + x);
            System.out.println("minX = " + minX);
            System.out.println("maxX = " + maxX);
            if (x < minX) {
                System.out.println("SMALL INVIS");
                textVisible = false;
            } else if (x >= maxX) {
                System.out.println(" BIG INVIS");
                textVisible = false;
            }
            System.out.println("The text is Visible: " + textVisible);

            // Draw text if it's not hidden by the square
            if (textVisible) {
                //S.drawString(g, text, new V2(textX, 0.51), Color.RED, new Font("Arial", Font.PLAIN, 65));
                x+=textScrollSpeed;

                ////////////////

                // Calculate the z-coordinate of the text

                // Split the text into parts based on its position relative to the square
                if (maxX > minX && textFront.isEmpty()) {

                    // Calculate the index where the text exceeds maxX
                    int splitIndex = text.length();
                    for (int i = 0; i < text.length(); i++) {
                        //if (fm.stringWidth(text.substring(0, i)) > maxX) {
                        double subStringWidth = (double) fm.stringWidth(text.substring(0, i))/100;
                        System.out.println("Split = " + subStringWidth);
                        if (subStringWidth > maxX) {
                            splitIndex = i;
                            break;
                        }
                    }

                    // Split the text
                    textFront = text.substring(0, splitIndex);
                    textBehind = text.substring(splitIndex);
                }

                // Calculate the width of the text parts
                int textWidthFront = fm.stringWidth(textFront);
                int textWidthBehind = fm.stringWidth(textBehind);

                // Draw text at the updated x-coordinate
                S.drawString(g, textFront, new V2(textX, 0.51), Color.RED, new Font("Arial", Font.PLAIN, 65));

                // Calculate the position to start drawing the text behind the square
                double textBehindX = textX + textWidthFront;



                // Draw the text behind the square
                //S.drawString(g, textBehind, new V2(textBehindX, 0.51), Color.RED, new Font("Arial", Font.PLAIN, 65));
            }


            //////////////////////////////////////////////

            /*
            // Calculate the z-coordinate of the text
            double zText = A.y; // Assuming Am, Bm, Cm, Dm are the corners of the square when it's in front

            // Check if text is in front of the square
            if (zText > 0) {
                // Draw text
                S.drawString(g, text, new V2(textX, 0.51), Color.RED, new Font("Arial", Font.PLAIN, 65));
            }
            */

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            String text = "Hello world";

            // Draw square
            S.drawLine(g, A, B);
            S.drawLine(g, B, C);
            S.drawLine(g, C, D);
            S.drawLine(g, D, A);
            S.drawLine(g, Am, Bm);
            S.drawLine(g, Bm, Cm);
            S.drawLine(g, Cm, Dm);
            S.drawLine(g, Dm, Am);

            // Calculate the boundaries of the square
            double minX = min(min(A.x, B.x), min(C.x, D.x));
            double maxX = max(max(A.x, B.x), max(C.x, D.x));

            // Check if any part of the text crosses the vertical boundaries of the square
            FontMetrics fm = g.getFontMetrics(new Font("Arial", Font.PLAIN, 65));
            int textWidth = fm.stringWidth(text) / 100;
            if (x < textWidth || x > maxX) {
                x = textX + textWidth;
            }
            //S.drawString(g, text, new V2(textX, 0.51), Color.RED, new Font("Arial", Font.PLAIN, 65));
            x += textScrollSpeed;

            ////////////////

            // Calculate the z-coordinate of the text

            // Split the text into parts based on its position relative to the square
            if (maxX > minX) {
                // Calculate the index where the text exceeds maxX
                int splitIndex = text.length();
                for (int i = 0; i < text.length(); i++) {
                    //if (fm.stringWidth(text.substring(0, i)) > maxX) {
                    double subStringWidth = (double) fm.stringWidth(text.substring(0, i)) / 100;
                    System.out.println("Split = " + subStringWidth);
                    System.out.println("X = " + x);
                    System.out.println("SubString = " + (subStringWidth));
                    if (x+subStringWidth > maxX) {
                        splitIndex = i;
                        break;
                    }
                }

                // Split the text
                textFront = text.substring(0, splitIndex);
                textBehind = text.substring(splitIndex);
            }

            // Calculate the width of the text parts
            int textWidthFront = fm.stringWidth(textFront);
            int textWidthBehind = fm.stringWidth(textBehind);

            // Draw text at the updated x-coordinate
            S.drawString(g, textFront, new V2(textX, 0.51), Color.RED, new Font("Arial", Font.PLAIN, 65));

            // Draw the text behind the square
            if (textBehind.equals(text)) {
                textX = 0.5;
                S.drawString(g, textBehind, new V2(0.51+textX, 0.51), Color.RED, new Font("Arial", Font.PLAIN, 65));
            } else {
                S.drawString(g, textBehind, new V2(0.5, 0.51), Color.RED, new Font("Arial", Font.PLAIN, 65));
            }

        }

        class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                // Increment x-coordinate of text
                textX += textScrollSpeed; // Adjust the value for desired speed
                repaint();
            }
        }
    }
}
