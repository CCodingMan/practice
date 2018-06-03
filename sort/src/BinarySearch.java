import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: ljj
 * @Date: 2018/6/3 13:16
 * @Description:二分法查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] array = {2,5,1,9,8,10,4};
        System.out.println("原数组："+Arrays.toString(array));
        Arrays.sort(array);
        int[] sortArray = Arrays.copyOf(array, array.length);
        System.out.println("排序后数组："+Arrays.toString(sortArray));
        Scanner s = new Scanner(System.in);
        System.out.println("请输入查找值：");
        int searchValue = s.nextInt();
        int res = bs.getArrayIndex(sortArray, searchValue);
        if(res == -1){
            System.out.println("查找值未找到!");
        }else{
            System.out.println("查找值找到，数组下标："+res+",数组值为："+sortArray[res]);
        }
    }

    /**
     * 获取查找后的数组下标
     * @param array 数组
     * @param number 查找值
     * @return 下标，-1未找到
     */
    private int getArrayIndex(int[] array, int number){


        int low = 0;
        int high = array.length-1;
        int notFind = -1;
        while (low<=high){
            int mid = low + (high - low)/2;
            if (number > array[mid]){
                low = mid+1;
            }else if(number < array[mid]){
                high = mid-1;
            }else{
                return mid;
            }
        }

        return notFind;
    }
}
