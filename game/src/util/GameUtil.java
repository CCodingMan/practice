package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @Auther: ljj
 * @Date: 2018/6/11 21:58
 * @Description:游戏工具类
 */
public class GameUtil {
    /**
     * 工具类通常将构造器私有
     */
    private GameUtil(){}

    /**
     * 加载图片
     * @param path 图片路径
     * @return 图片
     */
    public static Image getImage(String path){
        URL u = GameUtil.class.getClassLoader().getResource(path);
        BufferedImage img = null;
        try {
            if (u != null) {
                img = ImageIO.read(u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
