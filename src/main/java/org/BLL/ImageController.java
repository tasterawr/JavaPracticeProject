package org.BLL;

import org.models.Color;
import org.models.Image;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageController implements IImageController{
    private List<Image> images;

    public ImageController(){
        this.images = new ArrayList<>();
        createColor(255, 255, 255);
    }

    @Override
    public Image createImage(String imageName, int height, int width) {
        Image image = new Image(imageName, height, width);
        image.fillImage(Color.getColor(255,255,255));
        images.add(image);
        return image;
    }

    @Override
    public Color createColor(int redChannel, int greenChannel, int blueChannel) {
        return Color.getColor(redChannel, greenChannel, blueChannel);
    }

    @Override
    public boolean saveImage(Image image) {
        BufferedImage bufferedImage = new BufferedImage(image.getColorArray().length,
                image.getColorArray()[0].length,
                BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i<image.getHeight(); i++){
            for (int j=0;j<image.getWidth(); j++){
                //bufferedImage.setRGB();
            }
        }

        return false;
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
