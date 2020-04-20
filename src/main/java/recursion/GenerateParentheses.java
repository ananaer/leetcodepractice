//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<String>();

        public List<String> generateParenthesis(int n) {
            generate(0, 0, n, "");
            return result;
        }

        private void generate(int left, int right, int n, String curStr) {
            // 递归模板
            // 1. 写终止条件
            if (left == n && right == n) {
                result.add(curStr);
                return;
            }
            // 2. 本此循环要干的事
            // 3. 向下一层
            if (left < n) generate(left + 1, right, n, curStr + "(");
            if (right < left) generate(left, right + 1, n, curStr + ")");
            // 4.收尾本身的操作
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}