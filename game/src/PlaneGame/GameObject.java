package PlaneGame;

import java.awt.*;

/**
 * @Auther: ljj
 * @Date: 2018/6/21 21:32
 * @Description:游戏工具类
 */
public class GameObject {
    Image image;
    double x,y,speed;
    int width,height;

    public Rectangle getRect(){
        return new Rectangle((int)x, (int)y, width, height);
    }

    public GameObject() {
    }

    public GameObject(Image image, double x, double y, double speed, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
