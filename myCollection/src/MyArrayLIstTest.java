import com.ljj.bo.arraylist.MyArrayList;

/**
 * @Auther: ljj
 * @Date: 2018/6/26 21:54
 * @Description:测试
 */
public class MyArrayLIstTest {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("k");
        list.add("l");
        list.add("m");
        list.add("n");

        System.out.println(list.isEmpty());
//        System.out.println(list.remove(10));
        System.out.println(list.size());
    }

}
