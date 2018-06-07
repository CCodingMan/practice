import java.io.File;
import java.util.Scanner;

/**
 * @Auther: ljj
 * @Date: 2018/6/7 21:30
 * @Description: 递归打印文件路径（树状）
 */
public class PrintFilePath {
    public static void main(String[] args) {
        PrintFilePath pfp = new PrintFilePath();
        pfp.getFilePath();
    }

    private void getFilePath(){
        System.out.println("请输入文件夹或文件路径：");
        Scanner s = new Scanner(System.in);
        String path = s.next();
        File file = new File(path);
        printPath(file, 0);
    }

    private void printPath(File file, int count){
        for (int i=0; i<count; i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] f = file.listFiles();
            if (f != null) {
                for (File file1: f){
                    printPath(file1, count+1);
                }
            }
        }
    }
}
