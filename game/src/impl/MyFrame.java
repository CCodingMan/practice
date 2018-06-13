package impl;

import util.Constant;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: ljj
 * @Date: 2018/6/13 21:13
 * @Description:抽象父类
 */
public class MyFrame extends Frame {
    /**
     * 加载窗口
     */
    public void launchFrame(){
        setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        setLocation(100,100);
        setVisible(true);

        new PainThread().start();//启动

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 重画窗口
     */
    class PainThread extends Thread {
        @Override
        public void run() {
            //noinspection InfiniteLoopStatement
            while(true){
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
