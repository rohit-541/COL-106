package Lab1;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ASCIIArt {
    // Character set for ASCII art (from darkest to lightest)
    private static final String ASCII_CHARS ="'^ ;Ii~+ -?]aa[1)(|/tfjrxnuvczXYU.CLQ0OZmwqpdbkhao*#MW&8%$";


    public String[] generateASCIIArt(String imagePath) {
        try {
            // Read the image file
            BufferedImage image = ImageIO.read(new File(imagePath));

            // Resize image for better ASCII output
            int newWidth = 100; // Adjust this for finer detail
            int newHeight = (int) (image.getHeight() * (newWidth / (double) image.getWidth())*0.55);
            BufferedImage resizedImage = resizeImage(image, newWidth, newHeight);

            // Convert the resized image to ASCII
            return convertToASCII(resizedImage);

        } catch (IOException e) {
            System.out.println("Error reading the image: " + e.getMessage());
            return new String[0];
        }
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        resizedImage.getGraphics().drawImage(originalImage, 0, 0, width, height, null);
        return resizedImage;
    }

    private String[] convertToASCII(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        String[] asciiArt = new String[height];

        for (int y = 0; y < height; y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int gray = (getRed(rgb) + getGreen(rgb) + getBlue(rgb)) / 3; // Convert to grayscale
                int charIndex = mapToCharIndex(gray);
                row.append(ASCII_CHARS.charAt(charIndex));
            }
            asciiArt[y] = row.toString();
        }

        return asciiArt;
    }

    private int mapToCharIndex(int gray) {
        int numChars = ASCII_CHARS.length();
        return (gray * (numChars - 1)) / 255;
    }


    private int getRed(int rgb) {
        return (rgb >> 16) & 0xFF;
    }


    private int getGreen(int rgb) {
        return (rgb >> 8) & 0xFF;
    }

    private int getBlue(int rgb) {
        return rgb & 0xFF;
    }

    // Main method for testing
    public static void main(String[] args) {
        ASCIIArt asciiArt = new ASCIIArt();
        String imagePath = "./image.png";

        String[] art = asciiArt.generateASCIIArt(imagePath);
        for (String row : art) {
            System.out.println(row);
        }
    }
}
