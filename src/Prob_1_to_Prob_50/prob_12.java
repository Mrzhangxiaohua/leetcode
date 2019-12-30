package Prob_1_to_Prob_50;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * @Author: zf
 * @Date: 2019/6/11 14:29
 */
public class prob_12 {
    public static String intToRoman(int num) {
        Map<Integer, String> m = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        m.put(1000, "M");
        m.put(900, "CM");
        m.put(500, "D");
        m.put(400, "CD");
        m.put(100, "C");
        m.put(90, "XC");
        m.put(50, "L");
        m.put(40, "XL");
        m.put(10, "X");
        m.put(9, "IX");
        m.put(5, "V");
        m.put(4, "IV");
        m.put(1, "I");
        int data = num;
        for (Integer key : m.keySet()){
            int temp = data / key;
            if (temp == 0) continue;
            for (int j = temp; j > 0; j--){
                sb.append(m.get(key));
            }
            data = data % key;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        intToRoman(1994);
    }
}
