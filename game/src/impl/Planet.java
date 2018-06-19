package impl;

import util.GameUtil;

import java.awt.*;

/**
 * @Auther: ljj
 * @Date: 2018/6/14 20:53
 * @Description:行星
 */
public class Planet extends Star{
    double longAxis;
    double shortAxis;
    double speed;
    Star center;
    double degree;
    boolean satellite;

    public Planet(double longAxis, double shortAxis, double speed, Star center, String path, int width, int height){
        this.center = center;
        this.x = center.x + longAxis;
        this.y = center.y;
        this.image = GameUtil.getImage(path);

        this.longAxis = longAxis;
        this.shortAxis = shortAxis;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public Planet(double longAxis, double shortAxis, double speed, Star center, String path, int width, int height, boolean satellite){
        this(longAxis,shortAxis,speed,center,path,width,height);
        this.satellite = satellite;
    }

    public Planet(String path, double x, double y, int width, int height) {
        super(path, x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if(!satellite){
            drawTrace(g);
        }
        move();
    }

    public void move(){
        x = (center.x + center.width/2) + longAxis*Math.cos(degree);
        y = (center.y + center.height/2) + shortAxis*Math.sin(degree);
        degree += speed;
    }

    public void drawTrace(Graphics g){
        Color color = g.getColor();

        double ovalWidth = longAxis*2;
        double ovalHeigh = shortAxis*2;
        double ovalX = (center.x + center.width/2)-longAxis;
        double ovalY = (center.y + center.height/2)-shortAxis;

        g.setColor(Color.blue);
        g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeigh);

        g.setColor(color);
    }
}
