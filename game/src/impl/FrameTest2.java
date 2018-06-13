package impl;

import util.GameUtil;

import java.awt.*;

/**
 * @Auther: ljj
 * @Date: 2018/6/13 21:45
 * @Description:
 */
public class FrameTest2 extends MyFrame{
    /**
     * 加载图片
     */
    private Image image = GameUtil.getImage("images/sun.png");

    public static void main(String[] args) {
        FrameTest2 gf = new FrameTest2();
        gf.launchFrame();
    }

    private double x = 100;
    private double y = 100;
    private double degree = 3.14/3;//[0-2派]
//    private double speed = 10;
    @Override
    public void paint(Graphics g) {
//        if(speed > 0){
//            speed -= 0.02;
//        }else{
//            speed = 0;
//        }

        //画图片
        g.drawImage(image, (int) x, (int) y, 20, 20, null);
        x = 200 + 100*Math.cos(degree);
        y = 200 + 50*Math.sin(degree);
//        if(y > 500 - 30 || y < 30){
//            degree = -degree;
//        }
//        if(x > 500 - 30 || x < 30){
//            degree = Math.PI - degree;
//        }
        degree += 0.1;

        g.drawLine(100,100,(int)x,(int)y);
    }
}
