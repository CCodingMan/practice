import javafx.scene.shape.Circle;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *  递归调用（阶乘）
 */
public class Recursive {
    public static void main(String[] args) {
        circle();
    }

    private static int getRecursive(int source){
        if(source == 1) return 1;
        return source * getRecursive(source - 1);
    }

    private static void judge(Scanner s){
        System.out.println("是否继续计算阶乘？(y是，n退出)");
        String exit = s.nextLine();
        switch (exit){
            case "y":
                circle();
                break;

            case "n":
                break;

            default:
                judge(s);
        }
    }

    private static void circle(){
        System.out.println("请输入需要进行阶乘的正整数：");
        Scanner s= new Scanner(System.in);
        String str = s.nextLine();
        while (!Pattern.matches("^?[0-9]\\d*$",str)){
            System.out.println("输入不符合要求，请重新输入需要进行阶乘的正整数：");
            str = s.nextLine();
        }
        int source = Integer.valueOf(str);
        int result = getRecursive(source);
        System.out.println("阶乘结果为："+ result);

        judge(s);
    }
}
