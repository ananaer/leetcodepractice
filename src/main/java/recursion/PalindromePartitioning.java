//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
      public static void main(String[] args) {
           Solution solution = new PalindromePartitioning().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backTrack(res, new ArrayList<String>(), s, 0);
        return res;
    }

          private void backTrack(List<List<String>> res, List<String> tmp, String s, int start) {
              if (start == s.length()) {
                  res.add(new ArrayList<String>(tmp));
              } else {
                  for (int i = start; i < s.length(); i++) {
                      if (isPalindrome(s, start, i)){
                          tmp.add(s.substring(start, i + 1));
                          backTrack(res, tmp, s, i + 1);
                          tmp.remove(tmp.size() - 1);
                      }
                  }
              }
          }

          /**
           * 判断是否为回文串
           */
          private boolean isPalindrome(String s, int left, int right) {
              while (left < right){
                  if (s.charAt(left) != s.charAt(right)) {
                      return false;
                  }
                  left++;
                  right--;
              }
              return true;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }