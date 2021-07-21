package org.BLL;

import org.models.Image;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public interface IImageController {
    Image createImage(String imageName, int height, int width);
    Image drawLines(Image image, Color mainColor, Color secondaryColor, int step);
    Image drawLines(Image image, Color mainColor, Color secondaryColor, int step, boolean horizontalLines);
    boolean saveImage(Image image) throws IOException;
    boolean saveAllImages();
    List<Image> getImagesList();
    boolean deleteImage(String imageName);
}
