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
    Star star = new Star("images/sun.png",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2,40,40);
    Planet planet = new Planet(150, 100, 0.1, star, "images/earth.png", 20, 20);
    @Override
    public void paint(Graphics g) {
        g.drawImage(img,0,0,800,600,null);
        star.draw(g);
        planet.draw(g);
    }

    public static void main(String[] args) {
        SunFrame sf = new SunFrame();
        sf.launchFrame();
    }
}
