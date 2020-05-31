//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组

package dp;
  public class BestTimeToBuyAndSellStockIi {
      public static void main(String[] args) {
           Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
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
        // 本题不限制交易，因此k为正无穷，因此可以认为k=k-1;
        // 带入公式简化为:
        // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        // dp[i][1] = max(dp[i-1][1], dp[i-1][0]- prices[i])
        // 直接根据股票I的套路改改
        if (prices.length == 0) {
            return 0;
        }
        // 初始化值dp[-1][0]
        int dp_i_0 = 0;
        // dp[-1][1]
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int pre_dp_i_0 = dp_i_0;
            int pri_dp_i_1 = dp_i_1;
            dp_i_0 = Math.max(pre_dp_i_0, pri_dp_i_1 + prices[i]);
            dp_i_1 = Math.max(pri_dp_i_1, pre_dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }