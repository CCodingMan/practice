package PlaneGame;

import util.GameUtil;

import java.awt.*;

/**
 * @Auther: ljj
 * @Date: 2018/6/22 21:41
 * @Description:爆炸
 */
public class Explode {
    double x,y;
    static Image[] image = new Image[3];
    int count;

    static {
        for (int i=0; i<3; i++){
            image[i] = GameUtil.getImage("images/explode"+i+".png");
            image[i].getWidth(null);
        }
    }

    public void draw(Graphics g){
        if(count <= image.length-1){
            g.drawImage(image[count],(int)x,(int)y,null);
            count++;
        }
    }

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
