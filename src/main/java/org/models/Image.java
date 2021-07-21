package org.models;

public class Image {
    private String imageName;
    private int height;
    private int width;
    private Color [][] colorArray;

    public Image(String imageName, int height, int width) {
        this.imageName = imageName;
        this.height = height;
        this.width = width;
        this.colorArray = new Color[height][width];
    }

    public void fillImage(Color color){
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                colorArray[i][j] = color;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getImageName() {
        return imageName;
    }

    public Color[][] getColorArray() {
        return colorArray;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
