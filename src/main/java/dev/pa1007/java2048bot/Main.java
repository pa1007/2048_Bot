package dev.pa1007.java2048bot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] arguments) throws AWTException {
        GraphicsEnvironment ge      = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[]    screens = ge.getScreenDevices();


        Rectangle allScreenBounds = new Rectangle();
        for (GraphicsDevice screen : screens) {
            Rectangle screenBounds = screen.getDefaultConfiguration().getBounds();

            allScreenBounds.width += screenBounds.width;
            allScreenBounds.height = Math.max(allScreenBounds.height, screenBounds.height);
        }

        Robot         robot      = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(allScreenBounds);
        try {
            // Create temp file
            File temp = new File("screenshot.png");
            temp.createNewFile();

            // Use the ImageIO API to write the bufferedImage to a temporary file
            ImageIO.write(screenShot, "png", temp);

            // Delete temp file when program exits

        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
