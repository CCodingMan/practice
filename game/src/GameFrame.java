import util.GameUtil;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: ljj
 * @Date: 2018/6/11 21:05
 * @Description:窗口
 */
public class GameFrame extends Frame{
    /**
     * 加载图片
     */
    private Image image = GameUtil.getImage("images/sun.png");

    /**
     * 加载窗口
     */
    private void launchFrame(){
        setSize(500,500);
        setLocation(100,100);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        //画线
        g.drawLine(100, 100, 200, 200);
        //画圆
        g.drawOval(100, 100, 200, 200);
        //画矩形
        g.drawRect(100, 100, 200, 200);
        //字体设置
        Font f = new Font("微软雅黑", Font.BOLD, 15);
        g.setFont(f);
        //画笔颜色
        g.setColor(Color.red);
        //画字
        g.drawString("chinagoodman", 200, 200);

        g.setColor(Color.black);
        //填充矩形
        g.fillRect(100, 100, 50, 50);
        Color c = g.getColor();
        //填充圆形
        g.fillOval(300, 300, 50,50);
        //还原颜色
        g.setColor(c);
        //画图片
        g.drawImage(image, 200, 200, 20, 20, null);
    }

    public static void main(String[] args) {
        GameFrame gf = new GameFrame();
        gf.launchFrame();
    }
}
