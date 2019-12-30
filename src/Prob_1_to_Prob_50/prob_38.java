package Prob_1_to_Prob_50;

/**
 * @Description: 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。
 * @Author: zf
 * @Date: 2019/10/20 10:12
 */
public class prob_38 {
    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("11");
        if (n==1) return "1";
        if (n==2) return "11";
        for (int i = 0; i < n - 2; i++) {
            sb = getResult(sb);
        }
        return sb.toString();
    }

    public static StringBuilder getResult(StringBuilder stringBuilder){
        StringBuilder result = new StringBuilder();
        int count = 0;
        int now = 0;
        int temp = 0;
        // 1 初始
        char first = stringBuilder.charAt(0);
        for (int i = 0; i < stringBuilder.length(); i++) {
            char next = stringBuilder.charAt(i);
            // 2 分段，如果不等且不为最后一个
            if (first == next && i != stringBuilder.length()){
                count ++;
            }else {
                result.append(count);
                result.append(stringBuilder.charAt(i - 1));
                first = stringBuilder.charAt(i);
                temp = i;
                count = 1;
            }
            now = i;
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1)!= stringBuilder.charAt(stringBuilder.length()-2)){
            result.append(count);
            result.append(stringBuilder.charAt(now));
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1)== stringBuilder.charAt(temp) && temp!= (stringBuilder.length() - 1 )){
            result.append(count);
            result.append(stringBuilder.charAt(temp));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        countAndSay(n);
        String s = "1.     1\n" +
                   "2.     11\n" +
                   "3.     21" +
                   "4.     1211\n" +
                   "5.     111221\n" +
                   "6.     312211";

    }
}
