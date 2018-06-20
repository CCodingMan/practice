package PlaneGame;

import util.Constant;

import java.awt.*;

/**
 * @Auther: ljj
 * @Date: 2018/6/20 22:42
 * @Description:子弹
 */
public class Bullet {
    double x,y,speed,degree;
    int width = 10;
    int height = 10;

    public Bullet() {
    }

    public Bullet(double x, double y, double speed, int width, int height) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.degree = Math.random()*Math.PI*2;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillOval((int)x,(int)y,width,height);
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);
        if(y > Constant.GAME_HEIGHT - height-10 || y < height+20){
            degree = -degree;
        }
        if(x > Constant.GAME_WIDTH - width-10 || x < 15){
            degree = Math.PI - degree;
        }
        g.setColor(c);
    }
}
