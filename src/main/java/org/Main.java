package org;

import org.BLL.IImageController;
import org.BLL.ImageController;
import org.java_plilosophy_tasks.Tank;
import org.java_plilosophy_tasks.VampireNumbers;
import org.models.Image;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        executeImageController();
    }

    public static void executeImageController(){
        IImageController imageController = new ImageController();

        Image image1 = imageController.createImage("My_image1", 600, 800);
        Image image2 = imageController.createImage("My_image2", 600, 800);
        Image image3 = imageController.createImage("My_image3", 600, 800);
        imageController.drawLines(image1, Color.cyan, Color.black, 10);
        imageController.drawLines(image2, Color.green, Color.yellow, 50, true);
        imageController.drawLines(image3, Color.black, Color.white, 70, false);

        imageController.saveAllImages();
    }
}
