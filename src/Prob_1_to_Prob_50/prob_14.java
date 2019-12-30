package Prob_1_to_Prob_50;

/**
 * @Description:编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * @Author: zf
 * @Date: 2019/6/12 14:57
 */
public class prob_14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int maxlength = strs[0].length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < strs.length; i++) {
            if (maxlength > strs[i].length()) maxlength = strs[i].length();
        }
        boolean flag = false;
        for (int i = 0; i < maxlength; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) == strs[j].charAt(i)){
                    flag = true;
                    continue;
                }else {
                    flag = false;
                    break;
                }
            }
            if (flag){
                sb.append(strs[0].charAt(i));
            }else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"a"};
        longestCommonPrefix(strings);
    }
}
