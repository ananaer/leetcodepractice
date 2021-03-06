//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2: 
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
// Related Topics 动态规划

package dp;

import java.util.Arrays;

public class HouseRobber {
      public static void main(String[] args) {
           Solution solution = new HouseRobber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//          private int[] note;
    public int rob(int[] nums) {
        // 1.自底向上
        // dp[i] 表示从第i间房子开始抢，能抢到的最多的钱
        // 两种选择，抢或者不抢
        // 1.1 优化空间
        int dp_2 = 0;
        int dp_1 = 0;
        int dp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 抢了的话就是 上上间
            dp = Math.max(nums[i] + dp_2, dp_1);
            dp_2 = dp_1;
            dp_1 = dp;
        }
        //
        return dp;
        /*// 2.自顶向下 递归 带备忘录
        note = new int[nums.length];
        Arrays.fill(note, -1);
        return dp(nums, 0);*/
    }
         /* private int dp(int[] nums, int start) {
              // 跳出条件
              if (start >= nums.length) {
                  return 0;
              }
              if (note[start] != -1) {
                  return note[start];
              } else {
                  int max = Math.max(nums[start] + dp(nums, start + 2), dp(nums, start + 1));
                  note[start] = max;
                  return max;
              }
          }*/
}


//leetcode submit region end(Prohibit modification and deletion)

  }