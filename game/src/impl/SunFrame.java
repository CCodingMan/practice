package impl;

import util.Constant;
import util.GameUtil;

import java.awt.*;

/**
 * @Auther: ljj
 * @Date: 2018/6/13 22:06
 * @Description:太阳系图
 */
public class SunFrame extends MyFrame {
    Image img = GameUtil.getImage("images/background.jpg");
    Star sun = new Star("images/sun.png",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2,40,40);
    Planet earth = new Planet(100, 80, 0.1, sun, "images/earth.png", 20, 20);
    Planet moon = new Planet(40, 40, 0.3, earth, "images/moon.png", 20, 20,true);
    Planet mars = new Planet(200,130,0.2,sun,"images/saturn.png",20,20);

    @Override
    public void paint(Graphics g) {
        g.drawImage(img,0,0,800,600,null);
        sun.draw(g);
        earth.draw(g);
        moon.draw(g);
        mars.draw(g);
    }

    public static void main(String[] args) {
        SunFrame sf = new SunFrame();
        sf.launchFrame();
    }
}
