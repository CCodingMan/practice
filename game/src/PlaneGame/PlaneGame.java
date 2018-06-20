package PlaneGame;

import impl.MyFrame;
import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/6/19 21:48
 * @Description:雷霆战机
 */
public class PlaneGame extends MyFrame {
    Image bg  = GameUtil.getImage("images/background.jpg");
    Plane plane = new Plane("images/plane.png",350,400);
    List<Bullet> bulletList = new ArrayList<Bullet>();

    public void paint(Graphics g){
        g.drawImage(bg,0,0,null);
        plane.draw(g);
        for (Bullet bullet : bulletList){
            bullet.draw(g);
        }
    }

    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirect(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.removeDirect(e);
        }
    }

    @Override
    public void launchFrame() {
        super.launchFrame();
        addKeyListener(new KeyMonitor());
        for (int i=0; i<50; i++){
            Bullet bullet = new Bullet(Constant.GAME_WIDTH/2+5,Constant.GAME_HEIGHT/2+5,15,10,10);
            bulletList.add(bullet);
        }
    }

    public static void main(String[] args) {
        PlaneGame pg = new PlaneGame();
        pg.launchFrame();
    }
}
