package PlaneGame;

import impl.MyFrame;
import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/6/19 21:48
 * @Description:雷霆战机
 */
public class PlaneGame extends MyFrame {
    Image bg  = GameUtil.getImage("images/background.jpg");
    Plane plane = new Plane("images/plane.png",100,400,20);
    List<Bullet> bulletList = new ArrayList<Bullet>();

    Date startTime;
    Date endTime;
    Explode baozha = null;

    public void paint(Graphics g){
        g.drawImage(bg,0,0,null);
        plane.draw(g);
        for (Bullet bullet : bulletList){
            bullet.draw(g);
            //检测碰撞
            boolean peng = bullet.getRect().intersects(plane.getRect());
            if(peng){
                plane.setLive(false);
                if(baozha == null){
                    endTime = new Date();
                    baozha = new Explode(plane.getX(),plane.getY());
                }
                baozha.draw(g);
                break;
            }
        }

        if (!plane.isLive()){
            printInfo(g,"GAME OVER",30,Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2, Color.white);
            int liveTime = (int) (endTime.getTime() - startTime.getTime())/1000;
            printInfo(g,"存活时间："+liveTime+"秒",20,30,80, Color.yellow);
            switch (liveTime/10){
                case 0:
                case 1:
                    printInfo(g,"菜鸟",30,400,200, Color.yellow);
                    break;
                case 2:
                    printInfo(g,"正常",30,400,200, Color.yellow);
                    break;
                default:
                    printInfo(g,"高手",30,400,200, Color.yellow);
                    break;
            }
            
        }
    }

    public void printInfo(Graphics g, String str, int size, int x, int y, Color color){
        Color c = g.getColor();
        g.setColor(Color.white);
        Font f = new Font("微软雅黑",Font.BOLD,size);
        g.setFont(f);
        g.drawString(str,x,y);
        g.setColor(c);
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
        for (int i=0; i<10; i++){
            Bullet bullet = new Bullet(Constant.GAME_WIDTH/2+5,Constant.GAME_HEIGHT/2+5,15,10,10);
            bulletList.add(bullet);
        }
        startTime = new Date();
    }

    public static void main(String[] args) {
        PlaneGame pg = new PlaneGame();
        pg.launchFrame();
    }
}
