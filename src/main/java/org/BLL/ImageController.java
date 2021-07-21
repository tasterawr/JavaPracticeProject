package org.BLL;

import org.models.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageController implements IImageController{
    private List<Image> images;

    public ImageController(){
        this.images = new ArrayList<>();
    }

    @Override
    public Image createImage(String imageName, int height, int width) {
        Image image = new Image(imageName, height, width);
        image.fillImage(Color.green);
        images.add(image);
        return image;
    }

    @Override
    public Image drawLines(Image image, Color mainColor, Color secondaryColor, int step) {
        return image.drawLines(mainColor, secondaryColor, step, 0);
    }

    @Override
    public Image drawLines(Image image, Color mainColor, Color secondaryColor, int step, boolean horizontalLines) {
        if (horizontalLines){
            //draws horizontal lines
            return image.drawLines(mainColor, secondaryColor, step, 1);
        }
        else{
            return image.drawLines(mainColor, secondaryColor, step, 2);
        }

    }

    @Override
    public boolean saveImage(Image image) {
        BufferedImage bufferedImage = new BufferedImage(image.getColorArray()[0].length,
                image.getColorArray().length,
                BufferedImage.TYPE_INT_RGB);


        for (int i = 0; i<image.getHeight(); i++){
            for (int j=0;j<image.getWidth(); j++){
                bufferedImage.setRGB(j, i, image.getColorArray()[i][j].getRGB());
            }
        }

        File outputFile = new File(image.getImageName() + ".jpg");
        try {
            ImageIO.write(bufferedImage, "jpg", outputFile);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean saveAllImages() {
        for(Image im : images){
            if (!saveImage(im))
                return false;
        }

        return true;
    }

    @Override
    public List<Image> getImagesList() {
        return images;
    }

    @Override
    public boolean deleteImage(String imageName) {
        try{
            images.stream().filter(x -> x.getImageName().equals(imageName)).findFirst();
            return true;
        }
        catch(NullPointerException e){
            return false;
        }
    }
}
