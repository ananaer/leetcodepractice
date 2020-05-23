//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划

package dp;
  public class CoinChange {
      public static void main(String[] args) {
           Solution solution = new CoinChange().new Solution();
          solution.coinChange(new int[]{474,83,404,3}, 264);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 符合最优子结构，因为硬币是无限的
        // dp[i] 表示当金额为i时，需要花费的最少硬币
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            //初始化为最大值
            dp[i] = amount + 1;
            // 算出当前位置需要用到的最少硬币
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }