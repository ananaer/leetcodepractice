//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划

package dp;
  public class BestTimeToBuyAndSellStock {
      public static void main(String[] args) {
           Solution solution = new BestTimeToBuyAndSellStock().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int maxProfit(int[] prices) {
              // base case：
              //dp[-1][k][0] = dp[i][0][0] = 0
              //dp[-1][k][1] = dp[i][0][1] = -infinity
              //股票买卖问题通用公式,状态转移方程：
              //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
              //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
              //
              // 本题只能一笔交易，因此k=1;
              // 带入公式为:
              // dp[i][1][0] =  max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
              // dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
              //             = max(dp[i-1][1][1], - prices[i])
              // 因为dp[i-1][0][0]=0 不允许交易自然是0了,于此同时可能看出与K无关
              // 简化为
              // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
              // dp[i][1] = max(dp[i-1][1], - prices[i])
              // ----原始版本--
//              if (prices.length == 0) {
//                  return 0;
//              }
//              int[][] dp = new int[prices.length][2];
//              for (int i = 0; i < prices.length; i++) {
//                  // 处理特殊情况
//                  if (i - 1 == -1) {
//                      dp[i][0] = 0;
//                      dp[i][1] = -prices[i];
//                      continue;
//                  }
//                  dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//                  dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
//              }
//              return dp[prices.length - 1][0];
              // ----空间优化-----
              if (prices.length == 0) {
                  return 0;
              }
              // 初始化值dp[-1][0]
              int dp_i_0 = 0;
              // dp[-1][1]
              int dp_i_1 = Integer.MIN_VALUE;
              for (int i = 0; i < prices.length; i++) {
                  dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                  dp_i_1 = Math.max(dp_i_1, -prices[i]);
              }
              return dp_i_0;

          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }