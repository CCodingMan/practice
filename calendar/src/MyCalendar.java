import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @Auther: ljj
 * @Date: 2018/6/5 21:51
 * @Description: 打印日历
 */
public class MyCalendar {
    public static void main(String[] args) {
        MyCalendar mc = new MyCalendar();
        mc.getCalendar();
    }

    private void getCalendar(){
        System.out.println("请输入日期(例：2018-06-22)：");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = df.parse(str);
            Calendar c = new GregorianCalendar();
            c.setTime(d);
            int now = c.get(Calendar.DATE);
            int maxDay = c.getActualMaximum(Calendar.DATE);
            c.set(Calendar.DATE, 1);
            int day = c.get(Calendar.DAY_OF_WEEK);
            System.out.println("日\t一\t二\t三\t四\t五\t六");
            for (int i=1; i<=day-1; i++){
                System.out.print("\t");
            }
            for (int i=1; i<=maxDay; i++){
                if(i == now){
                    System.out.print("*");
                }
                    System.out.print(i+"\t");
                int w = c.get(Calendar.DAY_OF_WEEK);
                if (w == Calendar.SATURDAY){
                    System.out.println("\n");
                }
                c.add(Calendar.DATE,1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
