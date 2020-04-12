package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        // 1.排序后判断两个字符串是否相等 时间复杂度O(n*log(n))
        /*char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);
        if (new String(s_chars).equals(new String(t_chars))) {
            return true;
        } else {
            return false;
        } */

        // 2.使用Hash表判断，时间复杂度O(n)
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char s_key = s.charAt(i);
            char t_key = t.charAt(i);
            if (null == map.get(s_key)) {
                map.put(s_key, 1);
            } else {
                map.put(s_key, map.get(s_key) + 1);
            }
            if (null == map.get(t_key)) {
                map.put(t_key, -1);
            } else {
                map.put(t_key, map.get(t_key) - 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
