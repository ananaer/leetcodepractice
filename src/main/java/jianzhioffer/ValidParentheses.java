//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package jianzhioffer;

import java.util.*;

public class ValidParentheses {
      public static void main(String[] args) {
           Solution solution = new ValidParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        set.add('{');
        set.add('[');
        set.add('(');
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                // 左括号直接入栈
                stack.addLast(c);
            } else if (map.get(c).equals(stack.peekLast())) {
                // 匹配中直接出栈
                stack.removeLast();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }