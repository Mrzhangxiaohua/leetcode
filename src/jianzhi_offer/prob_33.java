package jianzhi_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 参考排序内容讲解 https://blog.csdn.net/qq_23179075/article/details/78753136
 * @Author: zf
 * @Date: 2020/1/10 15:11
 */
public class prob_33 {
    public String PrintMinNumber(int [] numbers) {
        String result = "";
        if (numbers == null || numbers.length == 0) return result;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i] + "");
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String num1 = o1 + o2;
                String num2 = o2 + o1;
                return num1.compareTo(num2);
            }
        });
        for (String str : list) {
            result +=str;
        }
        return result;
    }

    public static void main(String[] args) {
        prob_33 solution = new prob_33();
        int[] numbers = {3,32,321};
        solution.PrintMinNumber(numbers);
    }
}
