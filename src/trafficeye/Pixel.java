package trafficsignal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ramya Praneetha
 */
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

class Pixel {

    BufferedImage image;
    int width;
    int height;
//    double R[], G[], B[];
    int R[],G[],B[];
    public Pixel() {
        try {
//            File input = new File("/images/Test.jpg");
            image = ImageIO.read(getClass().getResource("Test1.png"));
            R = new int[1000];
            G = new int[1000];
            B = new int[1000];
//            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            int count = 0,avg=0,ravg=0,bavg=0,gavg=0;
            for (int k = 0; k < height-10; k += height / 10) {
                for (int l = 0; l < width-10; l += width / 10) {
                    ravg=bavg=gavg=0;
                    for (int i = k; i < k+10; i++) {
                        for (int j = l; j < l+10; j++) {

                            Color c = new Color(image.getRGB(j, i));
                            ravg += c.getRed();
                            gavg += c.getGreen();
                            bavg += c.getBlue();

                            System.out.println("S.No: " + count + " Red: " + R + "  Green: " + G + " Blue: " + B);
//               System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
                            count++;
                        }
                    }
                    R[count-1]=ravg;////////
                }
            }

        } catch (Exception e) {
            System.out.println("Exception" + e);
            e.printStackTrace();
        }
    }

    static public void main(String args[]) throws Exception {
        Pixel obj = new Pixel();
    }
}
