//输入一个字符串，打印出该字符串中字符的所有排列。
//
//
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//
//
// 示例:
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//
//
//
//
// 限制：
//
// 1 <= s 的长度 <= 8
// Related Topics 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZiFuChuanDePaiLieLcof {
      public static void main(String[] args) {
           Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
          String[] permutation = solution.permutation("aab");
          System.out.println(Arrays.toString(permutation));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public String[] permutation(String s) {
              // 题目类似 PermutationsIi
              List<String> curRes = new ArrayList<>();
              char[] chars = s.toCharArray();
              Arrays.sort(chars);
              boolean[] used = new boolean[chars.length];
              back_track(curRes, chars, new StringBuilder(), used);
              String[] res = new String[curRes.size()];
              for (int i = 0; i < curRes.size(); i++) {
                  res[i] = curRes.get(i);
              }
              return res;
          }

          private void back_track( List<String> res, char[] s, StringBuilder path, boolean[] userd){
              if(path.length() == s.length){
                  res.add(path.toString());
                  return;
              }
              for (int i = 0; i < s.length; i++) {
                  if (userd[i] || (i > 0 && s[i] == s[i-1] && !userd[i-1])) {
                      continue;
                  }
                  path.append(s[i]);
                  userd[i] = true;
                  back_track(res, s, path, userd);
                  userd[i] = false;
                  path.deleteCharAt(path.length() - 1);
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }