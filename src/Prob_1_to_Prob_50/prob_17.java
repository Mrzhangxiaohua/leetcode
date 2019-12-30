package Prob_1_to_Prob_50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/6/20 18:09
 */
public class prob_17 {
    public static List<String> letterCombinations(String digits) {
        List<String[]> list = new LinkedList<>();
        if (digits.equals("")) return new LinkedList<>();
        list.add(0,new String[]{});
        list.add(1,new String[]{});
        list.add(2, new String[]{"a", "b", "c"});
        list.add(3, new String[]{"d", "e", "f"});
        list.add(4, new String[]{"g", "h", "i"});
        list.add(5, new String[]{"j", "k", "l"});
        list.add(6, new String[]{"m", "n", "o"});
        list.add(7, new String[]{"p", "q", "r", "s"});
        list.add(8, new String[]{"t", "u", "v"});
        list.add(9, new String[]{"w", "x", "y", "z"});
        String[] x = digits.split("");
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            if (i == 0){
                for (int j = 0; j < list.get(Integer.parseInt(x[i])).length; j++) {
                    list1.add(list.get(Integer.parseInt(x[i]))[j]);
                }
            }else {
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < list1.size(); j++) {
                    for (int k = 0; k < list.get(Integer.parseInt(x[i])).length; k++) {
                        System.out.println(list1.get(j) + list.get(Integer.parseInt(x[i]))[k]);
                        temp.add(list1.get(j) + list.get(Integer.parseInt(x[i]))[k]);
                    }
                }
                list1 = temp;
            }
        }
        return list1;
    }

    public static void main(String[] args) {
        letterCombinations("");
    }
}
