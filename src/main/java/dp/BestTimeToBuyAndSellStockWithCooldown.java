//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划

package dp;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])
            // dp[i][1] = max(dp[i-1][1], dp[i-2][0] - price[i])
//              if (prices.length == 0) {
//                  return 0;
//              }
//              int[][] dp = new int[prices.length][2];
//              for (int i = 0; i < prices.length; i++) {
//                  if (i - 2 == -2) {
//                      dp[i][0] = 0;
//                      dp[i][1] = -prices[i];
//                      continue;
//                  }
//                  if (i - 2 == -1) {
//                      dp[i][0] = Math.max(dp[0][0], dp[0][1] + prices[i]);
//                      dp[i][1] = Math.max(dp[0][1], dp[0][0] - prices[i]);
//                      continue;
//                  }
//                  dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//                  dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
//              }
//              return dp[prices.length - 1][0];
            // 优化空间
            if (prices.length == 0) {
                return 0;
            }
            int dp_i_0 = 0;
            int dp_i_1 = -prices[0];
            int pre_i_0 = 0;
            for (int i = 0; i < prices.length; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, pre_i_0 - prices[i]);
                pre_i_0 = temp;
            }
            return dp_i_0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}