package jianzhi_offer;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @Author: zf
 * @Date: 2020/1/13 11:24
 */
public class prob_41 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i]))
                set.remove(array[i]);
            else
                set.add(array[i]);
        }
        Iterator next = set.iterator();
        boolean flag = false;
        while (next.hasNext()){
            if (!flag){
                num1[0] = (int) next.next();
                flag = true;
            }
            else
                num2[0] = (int) next.next();
        }
    }

    // 看不懂移位法，保留
    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        int OR = 0;
        for(int i = 0;i<array.length;i++)
            OR ^= array[i];
        int idx = 0;//OR从后数第几位是1，从1开始
        while(OR != 0){
            OR = OR >> 1;
            idx++;
        }
        num1[0] = 0;
        num2[0] = 0;
        for(int i = 0;i<array.length;i++){
            if((array[i]&(1<<(idx-1))) == 0)
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }
    public static void main(String[] args) {
        prob_41 solution = new prob_41();
        int[] array = {2,2,6,4,6,1,3,3};
        int[] num1= new int[1];
        int[] num2= new int[1];
        solution.FindNumsAppearOnce1(array, num1, num2);
    }
}
