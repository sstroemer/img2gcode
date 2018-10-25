import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Used to load, store and use a given image
 */
public class Image {
    private BufferedImage img;
    private int height, width;

    private BufferedImage mosaic = null;

    public Image(String filename) {
        load(filename);
    }

    private void load(String filename) {
        try {
            img = ImageIO.read(new File(filename));
            height = img.getHeight();
            width = img.getWidth();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createMosaic(int height, int width) {
        mosaic = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
    }

    private double rgb2grayscale(int r, int g, int b) {
        // from BT.601 (ITU-R recommendation)
        return (0.299*r + 0.587*g + 0.114*b);
    }
}
