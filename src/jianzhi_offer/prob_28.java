package jianzhi_offer;

import java.util.*;

/**
 * @Description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @Author: zf
 * @Date: 2020/1/9 15:09
 */
public class prob_28 {
    ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str == null) return null;
        char[] charArray = str.toCharArray();
        permutation(charArray,0);
        Collections.sort(result);
        return result;
    }
    public void permutation(char[] charArray, int beginIdx){
        // 如果越界，则返回
        if (beginIdx >= charArray.length) return;
        // 如果当前索引为最后一个元素，说明遍历到最后，直接把结果返回
        if (beginIdx == charArray.length - 1) {
            result.add(String.valueOf(charArray));
        }
        // 创建Set去重
        HashSet<Character> charset = new HashSet<>();
        // 遍历每个数据
        for (int i = beginIdx; i < charArray.length; i++) {
            // 当前没有选定一个结果时
            if (i == beginIdx){
                charset.add(charArray[i]);
                permutation(charArray, beginIdx + 1);
            }
            //
            else if (i != beginIdx && !charset.contains(charArray[i])){
                char temp = charArray[beginIdx];
                charArray[beginIdx] = charArray[i];
                charArray[i] = temp;
                permutation(charArray, beginIdx + 1);
                temp = charArray[beginIdx];
                charArray[beginIdx] = charArray[i];
                charArray[i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        String str = "abc";
        prob_28 solution = new prob_28();
        solution.Permutation(str);
    }
}
