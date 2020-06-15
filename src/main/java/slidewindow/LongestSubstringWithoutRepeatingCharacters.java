//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package slidewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
      public static void main(String[] args) {
          Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
          int abcabcbb = solution.lengthOfLongestSubstring("abcabcbb");
          System.out.println(abcabcbb);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int lengthOfLongestSubstring(String s) {
              int left = 0, right = 0;
              Map<Character, Integer> window = new HashMap<>();
              int result = Integer.MIN_VALUE;
              while (right < s.length()) {
                  char rightChar = s.charAt(right);
                  right++;
                  int update = window.get(rightChar) == null ? 1 : window.get(rightChar) + 1;
                  window.put(rightChar, update);
                  // 收缩条件存在重复字符时
                  while (window.get(rightChar) > 1) {
                      char leftChar = s.charAt(left);
                      left++;
                      window.put(leftChar, window.get(leftChar) == null ? 0 : window.get(leftChar) - 1);
                  }
                  result = right - left > result ? right - left : result;
              }
              return result == Integer.MIN_VALUE ? 1 : result;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }