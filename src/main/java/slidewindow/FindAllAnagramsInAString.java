//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表

package slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
      public static void main(String[] args) {
           Solution solution = new FindAllAnagramsInAString().new Solution();
          solution.findAnagrams("abacbabc", "abc");

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        // 初始化-计算p中所有字符的个数
        for (int i = 0; i < p.length(); i++) {
            int update = need.get(p.charAt(i)) == null ? 1 : need.get(p.charAt(i)) + 1;
            need.put(p.charAt(i), update);
        }
        int left = 0, right = 0, valid = 0;
        List<Integer> result = new ArrayList<>();
        while (right < s.length()) {
            // 扩充窗口
            char rightChar = s.charAt(right);
            right++;
            if (need.containsKey(rightChar)) {
                int update = window.get(rightChar) == null ? 1 : window.get(rightChar) + 1;
                window.put(rightChar, update);
                if (need.get(rightChar) == update) {
                    valid++;
                }
            }
            System.out.println("window"+window+"need"+need);
            // 当窗口内有全部的字符时，收缩
            while (need.size() == valid) {
                System.out.println("left"+left+"right"+right);
                 if (right - left == p.length()) {
                    result.add(left);
                }
                char leftChar = s.charAt(left);
                left++;
                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar).equals(need.get(leftChar))) {
                        valid--;
                    }
                    int update = window.get(leftChar) == null ? 0 : window.get(leftChar) - 1;
                    window.put(leftChar, update);
                }
            }

        }
        System.out.println(result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }