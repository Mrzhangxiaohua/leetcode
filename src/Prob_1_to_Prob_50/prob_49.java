package Prob_1_to_Prob_50;

import java.util.*;

/**
 * @Description: 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * @Author: zf
 * @Date: 2019/11/5 21:30
 * 注意：当出现aab和字符ab，这种单用set是不够的
 */
public class prob_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 想办法维护一个Key：List
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        prob_49 solution = new prob_49();
        List<List<String>> lists = solution.groupAnagrams(strings);
        System.out.println(lists);
    }
}
