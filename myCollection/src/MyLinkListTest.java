import com.ljj.bo.linklist.MyLinkList;

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
//        System.out.println(list.get(1));
//        list.remove(1);
//        System.out.println("value: "+list.get(1)+" ,size: "+list.size());
        for (int i=0; i<list.size(); i++) {
            System.out.println("before: "+list.get(i));
        }

        list.add(0,"d");
        list.add(2,"e");
        list.add(5,"f");

        for (int i=0; i<list.size(); i++) {
            System.out.println("after: "+list.get(i));
        }
    }
}
