package jianzhi_offer;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @Author: zf
 * @Date: 2020/1/16 9:23
 */
public class prob_55 {
    //Insert one char from stringstream
    ArrayList<Character> list = new ArrayList<>();
    HashSet<Character> hashSet = new HashSet<>();

    public void Insert(char ch) {
        if (!hashSet.contains(ch)) {
            if (list.contains(ch)) {
                list.remove((Character) ch);
                hashSet.add(ch);
            } else {
                list.add(ch);
            }
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (list.size() == 0) return '#';
        else return list.get(0);
    }
}
