import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Auther: ljj
 * @Date: 2018/6/2 20:06
 * @Description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        bs.printTip();
    }

    /**
     *  输入
     */
    private void printTip(){
        System.out.println("请输入待排序数字并以','隔开(必须以数字开头或结尾)：");
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println("请输入待排序方式(1升序，2降序)：");
        String sortType = s.next();

        judgeEmpty(str, sortType);

        String p = "[1-2]";
        judgeMatch(p, sortType, s);

        String pattern = "[0-9][0-9,]+[0-9]";
        judgeMatch(pattern, str, s);

        String[] strArray = str.split(",");
        boolean isTrue = Arrays.stream(strArray).allMatch(arr -> arr.matches("[0-9]+"));
        if (!isTrue) {
            inputErro(s);
            return;
        }
        Integer[] intArray = Arrays.stream(strArray).map(Integer::valueOf).toArray(Integer[]::new);
        Integer[] sortArray = bubbleSort(intArray, sortType);
        String result = Arrays.stream(sortArray).map(Object::toString).collect(Collectors.joining(","));
        System.out.println(result);
        System.out.println("是否继续输入(1继续，2退出)：");
        String in = s.next();

        judgeEmpty(in);

        judgeMatch(p, in, s);

        if ("1".equals(in)) printTip();

        if ("2".equals(in)) {
            System.out.println("...程序已退出!");
        }
    }

    private void inputErro(Scanner s) {
        System.out.println("您的输入不符合要求，继续输入请按1，退出请按2：");
        String input = s.next();
        while(!"1".equals(input) && !"2".equals(input)){
            System.out.println("您的输入不符合要求，继续输入请按1，退出请按2：");
        }
        if ("1".equals(input)) printTip();

        if ("2".equals(input)) {
            System.out.println("...程序已退出!");
        }
    }

    private Integer[] bubbleSort(Integer[] source, String sortType){
        Integer temp;
        for (int i=0; i<source.length; i++){
            for (int j=0; j<source.length-i-1; j++){
                if (source[j] > source[j+1]){
                    if ("1".equals(sortType)){
                        temp = source[j];
                        source[j] = source[j+1];
                        source[j+1] = temp;
                    }
                }else{
                    if ("2".equals(sortType)){
                        temp = source[j];
                        source[j] = source[j+1];
                        source[j+1] = temp;
                    }
                }

            }
        }
        return source;
    }

    private void judgeEmpty(String... strings){
        for (String str : strings){
            if (str.isEmpty()) {
                printTip();
                return;
            }
        }
    }

    private void judgeMatch(String pattern, String content, Scanner s){
        boolean isMatch = Pattern.matches(pattern, content);
        if (!isMatch) {
            inputErro(s);
        }
    }
}
