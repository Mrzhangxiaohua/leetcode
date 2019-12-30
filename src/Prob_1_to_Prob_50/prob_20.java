package Prob_1_to_Prob_50;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * @Author: zf
 * @Date: 2019/7/1 21:05
 */
public class prob_20 {
    public static boolean isValid(String s) {
        if (s.length() == 1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                // 如果当前拿到的元素与闭合元素匹配的元素
                char top_element = stack.empty()?'#': stack.pop();
                if (top_element != map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        if (stack.empty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String string= "((";
        boolean bool = isValid(string);
        System.out.println(bool);
    }
}
