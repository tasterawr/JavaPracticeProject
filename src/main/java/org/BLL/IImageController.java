package org.BLL;

import org.models.Color;
import org.models.Image;

import java.util.ArrayList;
import java.util.List;

public interface IImageController {
    Image createImage(String imageName, int height, int width);
    Color createColor(int redChannel, int greenChannel, int blueChannel);
    boolean saveImage(Image image);
    List<Image> getImagesList();
    boolean deleteImage(String imageName);
}
