package ru.netology.graphics.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;


public class Converter implements TextGraphicsConverter {

    private int maxWidth;
    private int maxHeight;
    private double maxRatio;
    private TextColorSchema schema;

    @Override
    public String convert(String url) throws IOException, BadImageSizeException {
        BufferedImage img = ImageIO.read(new URL(url));
        int newWidth = img.getWidth();
        int newHeight = img.getHeight();
        int ratio = img.getWidth()/ img.getHeight();
        if (ratio > maxRatio){
            throw new BadImageSizeException(ratio,maxRatio);
        }
        if (newWidth < maxWidth){
            newWidth = maxWidth;
            newHeight = newHeight/(newWidth/maxWidth);
        }
        Image scaledImage = img.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH);
        BufferedImage bwImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D graphics = bwImg.createGraphics();
        graphics.drawImage(scaledImage, 0, 0, null);
        WritableRaster bwRaster = bwImg.getRaster();
        int color = 0;
        StringBuilder result = new StringBuilder();
        char charColor;
        for (int h = 0; h < newHeight; h++){
            for (int w = 0;w < newWidth;w++){
                color = bwRaster.getPixel(w,h, new int[3])[0];
                if (schema == null){
                    schema = new Schema();
                }
                charColor = schema.convert(color);
                result.append(charColor);
            }
            result.append("\n");
        }
        return String.valueOf(result);
    }

    @Override
    public void setMaxHeight(int height) {
        this.maxHeight = height;
    }

    @Override
    public void setMaxWidth(int width) {
        this.maxWidth = width;
    }

    @Override
    public void setMaxRatio(double maxRatio) {
        this.maxRatio = maxRatio;
    }

    @Override
    public void setTextColorSchema(TextColorSchema schema) {
        this.schema = schema;
    }
}
