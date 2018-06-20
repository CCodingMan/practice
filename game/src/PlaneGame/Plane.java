package PlaneGame;

import util.GameUtil;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @Auther: ljj
 * @Date: 2018/6/20 21:43
 * @Description:
 */
public class Plane {
    Image image;
    double x,y;
    double speed = 20;
    boolean left,right,up,down;

    public Plane() {}

    public Plane(String path, double x, double y) {
        this.image = GameUtil.getImage(path);
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){
        g.drawImage(image,(int)x,(int)y,null);
        move();
    }

    public void move(){
        if(left){
            x -= speed;
        }
        if(up){
            y -= speed;
        }
        if(right){
            x += speed;
        }
        if(down){
            y += speed;
        }

    }

    public void addDirect(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                //左
                left = true;
                break;

            case KeyEvent.VK_UP:
                //上
                up = true;
                break;

            case KeyEvent.VK_RIGHT:
                //下
                right = true;
                break;

            case KeyEvent.VK_DOWN:
                //右
                down = true;
                break;

            default:
                break;
        }
    }

    public void removeDirect(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                //左
                left = false;
                break;

            case KeyEvent.VK_UP:
                //上
                up = false;
                break;

            case KeyEvent.VK_RIGHT:
                //下
                right = false;
                break;

            case KeyEvent.VK_DOWN:
                //右
                down = false;
                break;

            default:
                break;
        }
    }
}
