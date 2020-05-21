//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

package dp;
  public class MaximumSubarray {
      public static void main(String[] args) {
           Solution solution = new MaximumSubarray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        /* 动态规划
         定义状态dp[j] 代表从0到j位中子数列的最大和
         那么dp[j+1]就等于num[j]与num[j]+dp[j]的中最大值就好了
         由于只需要比较前一个数所以不用申请额外数组*/
        int max_end = nums[0];
        // 记录结果
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_end = Math.max(max_end + nums[i], nums[i]);
            result = Math.max(result, max_end);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }