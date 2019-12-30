package Prob_1_to_Prob_50;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * @Author: zf
 * @Date: 2019/6/12 9:39
 */
public class prob_13 {
    public static int romanToInt(String s) {
        int sum = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        String s1 = null;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (i != s.length() - 1){
                s1 = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i+1));
            }else {
                s1 = String.valueOf(s.charAt(i));
            }

            String s2 = String.valueOf(s.charAt(i));
            if (map.containsKey(s1)){
                i = i + 1;
                sum += map.get(s1);
            }else {
                sum += map.get(s2);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        romanToInt("IV");
    }
}
