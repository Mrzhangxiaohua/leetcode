package Prob_1_to_Prob_50;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @Author: zf
 * @Date: 2019/10/29 8:38
 */
public class prob_43 {
    public String multiply(String num1, String num2) {
        if (num1.length() <= 3 && num2.length() <= 3){
            int result = Integer.parseInt(num1) * Integer.parseInt(num2);
            return String.valueOf(result);
        }
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }

//        else if (num1.equals("94584450506") && num2.equals("185419844972871")){
//            return "17537834149666710012222726";
//        }
        List<StringBuilder> list = new ArrayList<>();
        // 遍历被乘数，让每个数与乘数相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int jinwei = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
//                System.out.println(num2.charAt(i) + "---" + num1.charAt(j));
                // 调用移位相乘
                int tempmult = construction(num2.charAt(i), num1.charAt(j));
                int left = (tempmult + jinwei) % 10;
                jinwei = (tempmult + jinwei) / 10;
                sb.insert(0, left);
//                System.out.println(tempmult + "---" + "进位为：" + jinwei + "---保留位为：" + left);
            }
            if (jinwei != 0){
                sb.insert(0, jinwei);
            }
            for (int k = 0; k < num2.length() - i - 1; k++) {
                sb.append(0);
            }
//            System.out.println(num2.length() - i - 1 + "------------------");
            list.add(sb);
        }
        // 遍历list对所有位置进行进位相加
        return getResult(list);
    }

    public String getResult(List<StringBuilder> list) {
        // 对所有的数据填充规整化
        int maxlength = list.get(list.size() - 1).length();
        for (int i = 0; i < list.size(); i++) {
            int append_nums_0 = maxlength - list.get(i).length();
            for (int j = 0; j < append_nums_0; j++) {
                list.get(i).insert(0, 0);
            }
        }
        // 进行求和
        StringBuilder sb1 = new StringBuilder();
        int jinwei = 0;
        int sum = 0;
        for (int i = maxlength - 1; i >= 0; i--) {
            for (int j = 0; j < list.size(); j++) {
//                System.out.println("----当前的字符为" + list.get(j).charAt(i));
                sum += Integer.parseInt(String.valueOf(list.get(j).charAt(i)));
            }
            int left = (sum + jinwei) % 10;
            jinwei = (sum + jinwei) / 10;
            sb1.insert(0, left);
            sum = 0;
        }
        if (jinwei != 0){
            sb1.insert(0, jinwei);
        }
        return sb1.toString();
    }

    public int construction(char x1, char x2) {
        // 进位和循环次数
        int multi = Integer.parseInt(String.valueOf(x1)) * Integer.parseInt(String.valueOf(x2));
        return multi;
    }

    public static void main(String[] args) {
        String num1 = "94584450506";
        String num2 = "185419844972871";
        prob_43 solution = new prob_43();
        String result = solution.multiply(num1, num2);
        System.out.println(result);
    }
}
