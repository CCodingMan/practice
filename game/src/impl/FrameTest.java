package impl;

import util.GameUtil;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: ljj
 * @Date: 2018/6/12 21:51
 * @Description:模拟台球轨迹
 */
public class FrameTest extends Frame{
    /**
     * 加载图片
     */
    private Image image = GameUtil.getImage("images/sun.png");

    public static void main(String[] args) {
        FrameTest gf = new FrameTest();
        gf.launchFrame();
    }

    /**
     * 加载窗口
     */
    private void launchFrame(){
        setSize(500,500);
        setLocation(100,100);
        setVisible(true);

        new FrameTest.PainThread().start();//启动

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private double x = 100;
    private double y = 100;
    private double degree = 3.14/3;//[0-2派]
    private double speed = 10;
    @Override
    public void paint(Graphics g) {
        if(speed > 0){
            speed -= 0.02;
        }else{
            speed = 0;
        }

        //画图片
        g.drawImage(image, (int) x, (int) y, 20, 20, null);
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);
        if(y > 500 - 30 || y < 30){
            degree = -degree;
        }
        if(x > 500 - 30 || x < 30){
            degree = Math.PI - degree;
        }
    }

    /**
     * 重画窗口
     */
    class PainThread extends Thread {
        @SuppressWarnings("Duplicates")
        @Override
        public void run() {
            //noinspection InfiniteLoopStatement
            while(true){
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
