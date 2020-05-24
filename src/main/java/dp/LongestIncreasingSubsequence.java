//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
      public static void main(String[] args) {
           Solution solution = new LongestIncreasingSubsequence().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int lengthOfLIS(int[] nums) {
              // 定义dp[i] 表示以nums[i]为结尾的最大子序列的长度
              // 状态转移方程：遍历前面小于nums[i]的dp并加上结果本身,最后取最大值
              if (nums.length == 0) {
                  return 0;
              }
              int[] dp = new int[nums.length];
              int result = dp[0];
              for (int i = 0; i < dp.length; i++) {
                  // 初始值为1 因为默认就有自己
                  dp[i] = 1;
                  for (int j = 0; j < i; j++) {
                      if (nums[i] > nums[j]) {
                          dp[i] = Math.max(dp[i], dp[j] + 1);
                      }
                  }
                  result = Math.max(result, dp[i]);
              }
              return result;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }