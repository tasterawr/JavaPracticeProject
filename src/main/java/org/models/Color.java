package org.models;

import java.util.ArrayList;
import java.util.List;

public class Color {
    private static List<Color> colorList = new ArrayList<>();
    private final int redChannel;
    private final int greenChannel;
    private final int blueChannel;

    private Color(int redChannel, int greenChannel, int blueChannel){
        this.redChannel = redChannel;
        this.greenChannel = greenChannel;
        this.blueChannel = blueChannel;
    }

    /** Возвращает объект цвета Color для переданных RGB параметров.*/
    public static Color getColor(int redChannel, int greenChannel, int blueChannel){
        for (Color c : colorList){
            if (c.redChannel == redChannel && c.greenChannel == greenChannel && c.blueChannel == blueChannel)
                return c;
        }

        Color color = new Color(redChannel, greenChannel, blueChannel);
        colorList.add(color);
        return color;
    }

    public int getRedChannel() {
        return redChannel;
    }

    public int getGreenChannel(){
        return greenChannel;
    }

    public int getBlueChannel() {
        return blueChannel;
    }
}
