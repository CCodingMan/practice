package impl;

import util.GameUtil;

import java.awt.*;

/**
 * @Auther: ljj
 * @Date: 2018/6/13 22:56
 * @Description:星体
 */
public class Star {
    private Image image;
    private double x;
    private double y;
    private int width;
    private int height;

    public Star(String path, double x, double y, int width, int height){
        this.image = GameUtil.getImage(path);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g){
        g.drawImage(image, (int)x, (int)y, width, height,null);
    }
}
