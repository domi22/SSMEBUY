package com.del.tools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
* @ClassName: CaptchaUtil 
* @Description: 关于验证码的工具类
* @author domi
* @date 2016-5-7 上午8:33:08 
* @version 1.0
 */
public class CaptchaUtil {

/*
 * 无参构造方法	
 */
private CaptchaUtil(){}
    
    /*
     * 随机字符字典,除去 O,0，1，L这几个不好区分的字符
     */
    private static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8',
        '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
        'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    
    /*
     * 生成随机数
     */
    private static Random random = new Random();
    
    /*
     * 获取6位随机数
     */
    private static String getRandomString()
    {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < 6; i++)
        {
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }
    
    /*
     * 获取随机数颜色
     */
    private static Color getRandomColor()
    {
        return new Color(random.nextInt(255),random.nextInt(255),
                random.nextInt(255));
    }
    
    /*
     * 返回某颜色的反色
     */
    private static Color getReverseColor(Color c)
    {
        return new Color(255 - c.getRed(), 255 - c.getGreen(),
                255 - c.getBlue());
    }
    
    public static void outputCaptcha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {

        response.setContentType("image/jpeg");

        String randomString = getRandomString();
        request.getSession(true).setAttribute("randomString", randomString);

        //控制前台验证码框的长度
        int width = 100;        
        //调节验证框的宽度
        int height = 30;

        //生成验证框的颜色，和相反的验证码颜色
        Color color = getRandomColor();
        Color reverse = getReverseColor(color);
        
        //生成验证码的图片
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(randomString, 18, 20);
        for (int i = 0, n = random.nextInt(100); i < n; i++) 
        {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }

        // 转成JPEG格式
        ServletOutputStream out = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(bi);
        out.flush();
    }
}
