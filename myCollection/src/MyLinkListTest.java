import com.ljj.linklist.MyLinkList;

/**
 * @Auther: ljj
 * @Date: 2018/6/27 21:27
 * @Description:LinkList测试
 */
public class MyLinkListTest {
    public static void main(String[] args) {
        MyLinkList list = new MyLinkList();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.size());
    }
}
