//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window

package slidewindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
      public static void main(String[] args) {
           Solution solution = new PermutationInString().new Solution();
          solution.checkInclusion("ab", "eidbaooo");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public boolean checkInclusion(String s1, String s2) {
              Map<Character, Integer> window = new HashMap<>();
              Map<Character, Integer> need = new HashMap<>();
              // 初始化
              for (int i = 0; i < s1.length(); i++) {
                  Integer count = need.get(s1.charAt(i));
                  int updateCount = count == null ? 1 : ++count;
                  need.put(s1.charAt(i), updateCount);
              }
              // 开始滑动窗口
              // 左右边界
              int left = 0, right = 0;
              // 有效
              int valid = 0;
              while (right < s2.length()) {
                  // 先更新右窗口
                  char rightChar = s2.charAt(right);
                  right++;
                  if (need.containsKey(rightChar)) {
                      int newValue = window.get(rightChar) == null ? 1 : window.get(rightChar) + 1;
                      window.put(rightChar, newValue);
                      if (newValue == need.get(rightChar)) {
                          valid++;
                      }
                  }
                  System.out.println("window"+window+"valid"+valid+"need"+need);
                  // 收缩窗口
                  while (valid == need.size()) {
                      // 终结条件
                      if (right - left == s1.length()) {
                          return true;
                      }
                      char leftChar = s2.charAt(left);
                      left++;
                      if (need.containsKey(leftChar)) {
                          int newValue = window.get(leftChar) == null ? 0 : window.get(leftChar) -1;
                          // 当不满足对应的字符数量时要减去有效值
                          if (window.get(leftChar).equals(need.get(leftChar))) {
                              valid--;
                          }
                          window.put(leftChar, newValue);
                      }
                  }
              }
              return false;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }