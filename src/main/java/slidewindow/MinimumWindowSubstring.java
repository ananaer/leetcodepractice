//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package slidewindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
      public static void main(String[] args) {
           Solution solution = new MinimumWindowSubstring().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        //滑动窗口双指针问题 整体思路先窗口右移找可行解，在左移找最优解
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer value = need.get(c);
            if (value == null) {
                need.put(c, 1);
            } else {
                need.put(c, ++value);
            }
        }
        int left = 0;
        int right = 0;
        int vaild = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // 先更新右边窗口
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                int count = window.get(c) == null ? 1 : window.get(c) + 1;
                window.put(c, count);
                int needCount = need.get(c) == null ? 0 : need.get(c);
                if (count == needCount) {
                    vaild++;
                }
            }
            // 找到所有可行解了，开始找最优解
            while (vaild == need.size()) {
                char d = s.charAt(left);
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                left++;
                if (need.containsKey(d)) {
                    int count = window.get(d);
                    int needCount = need.get(d) == null ? 0 : need.get(d);
                    if (count == needCount) {
                        vaild--;
                    }
                    window.put(d, --count);

                }
                // 找到
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }