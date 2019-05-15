package http3;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * AWT编程
 */
public class MessageImage {

    //根据信息得到图片（带阴影的艺术字）
    public static BufferedImage makeMessageImage(String message,
                                                 String fontName,
                                                 int fontSize){
        Font font = new Font(fontName,Font.PLAIN,fontSize);
        //封装字体在屏幕上呈现的信息
        FontMetrics metrics = getFontMetrics(font);
        int messageWidth = metrics.stringWidth(message);
        int baselineX = messageWidth / 10;
        int width = messageWidth + 2 * (baselineX + fontSize);
        int height = fontSize * 7 / 2;
        int baselineY = height * 8 / 10;
        BufferedImage messageImage = new BufferedImage(width,height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) messageImage.getGraphics();
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0,0,width,height);
        g2d.setFont(font);
        g2d.translate(baselineX,baselineY);
        g2d.setPaint(Color.lightGray);
        AffineTransform origTransform = g2d.getTransform();
        g2d.shear(-0.95,0);
        g2d.scale(1,3);
        g2d.drawString(message,0,0);
        g2d.setTransform(origTransform);
        g2d.setPaint(Color.BLACK);
        g2d.drawString(message,0,0);
        return messageImage;
    }

    //将图片写入指定IO流（或者文件中）
    public static void writeJPEG(BufferedImage image,
                                 OutputStream out){
        try{
            ImageIO.write(image,"jpg",out);
        } catch (IOException e) {
            System.err.println("Error outputting JPEG: " + e);
        }
    }

    //得到字体名称
    public static String[] getFontNames(){
        GraphicsEnvironment env =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        return env.getAvailableFontFamilyNames();
    }

    private static FontMetrics getFontMetrics(Font font){
        //参数（宽，高，种类）
        BufferedImage tempImage = new BufferedImage(1,1,
                BufferedImage.TYPE_INT_RGB);
        //提供对图形化界面更复杂的控制
        Graphics2D g2d = (Graphics2D) tempImage.getGraphics();
        return g2d.getFontMetrics();
    }
}
