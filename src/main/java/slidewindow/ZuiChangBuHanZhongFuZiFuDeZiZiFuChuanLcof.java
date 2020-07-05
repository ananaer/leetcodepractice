//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
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
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window

package slidewindow;

import java.util.HashSet;
import java.util.Set;

public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
      public static void main(String[] args) {
           Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
          int au = solution.lengthOfLongestSubstring("ab");
          System.out.println(au);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int lengthOfLongestSubstring(String s) {

              int left = 0, right = 0;
              Set<Character> window = new HashSet<>();
              int result = 0;
              while (right < s.length()) {
                  char rightChar = s.charAt(right);
                  if (!window.contains(rightChar)) {
                      right++;
                      window.add(rightChar);
                  }else {
                      while (window.contains(rightChar))
                      {
                          char leftChar = s.charAt(left);
                          left++;

                          window.remove(leftChar);
                      }
                  }
                  result = Math.max(result, window.size());
              }
              return result;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }