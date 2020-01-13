package jianzhi_offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 * @Author: zf
 * @Date: 2020/1/10 16:52
 */
public class prob_35 {
    //
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) return -1;
        int result = Integer.MAX_VALUE;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if (hashMap.containsKey(character)){
                hashMap.put(character, -1);
            }
            else {
                hashMap.put(character, i);
            }
        }
        for (int index: hashMap.values()) {
            if (index != -1){
                result = Math.min(result, index);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        prob_35 solution = new prob_35();
        solution.FirstNotRepeatingChar("google");
    }
}
