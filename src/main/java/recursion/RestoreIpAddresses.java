//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
      public static void main(String[] args) {
           Solution solution = new RestoreIpAddresses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 3) {
            return res;
        }
        backtrack(res, s, new ArrayList<String>(), 0);
        return res;
    }
          // index表示遍历到的下标
          // path表示路径
          private void backtrack(List<String> res, String s, List<String> path, int index) {
              if (path.size() == 4) {
                  if (index == s.length()) {
                      res.add(String.join(".", path));
                  }
                  return;
              }
              // 一个ip地址最多三位数
              for (int i = 1; i <= 3; i++) {
                  // 如果当前位置距离 s 末尾小于 3 就不用再分段了，直接跳出循环即可
                  if (index + i > s.length()) {
                      break;
                  }
                  String substring = s.substring(index, index + i);
                  // 排除非法的枝叶
                  if ((substring.startsWith("0") && substring.length() > 1) || (Integer.parseInt(substring) > 255)) {
                      continue;
                  }
                  path.add(substring);
                  backtrack(res, s, path, index + i);
                  path.remove(path.size() - 1);
              }

          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }