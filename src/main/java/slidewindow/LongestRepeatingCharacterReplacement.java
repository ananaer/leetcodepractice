//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意: 
//字符串长度 和 k 不会超过 104。 
//
// 示例 1: 
//
// 输入:
//s = "ABAB", k = 2
//
//输出:
//4
//
//解释:
//用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2: 
//
// 输入:
//s = "AABABBA", k = 1
//
//输出:
//4
//
//解释:
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window

package slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
        System.out.println(solution.characterReplacement("ABAA", 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            Map<Character, Integer> windows = new HashMap<>();
            int left = 0, right = 0;
            // 当前窗口内最多的字符数
            int curMax = Integer.MIN_VALUE;
            int result = Integer.MIN_VALUE;
            while (right < s.length()) {
                char rightChar = s.charAt(right);
                right++;
                int updateCount = windows.get(rightChar) == null ? 1 : windows.get(rightChar) + 1;
                windows.put(rightChar, updateCount);
                curMax = Math.max(curMax, updateCount);
                System.out.println("window" + windows + "left" + left + "right" + right + "curMax"+curMax);
                // 当前窗口内最多的字符数 + k < 窗口的长度 = right -left + 1时 收缩窗口
                if (right - left > curMax + k ) {
                    char leftChar = s.charAt(left);
                    left++;
                    System.out.println("window inner" + windows + "left" + left + "right" + right+"curMax"+curMax);

                    if (windows.containsKey(leftChar)) {
                        windows.put(leftChar, windows.get(leftChar) - 1);
                    }
                }
                // 更新结果 为什么是在这里更新结果呢 因为这题比较特殊可行解就是最优解 因此要放在外层
                result = Math.max(result, right - left);
            }
            return result == Integer.MIN_VALUE ? s.length() : result;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
