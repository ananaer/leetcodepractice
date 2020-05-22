//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划

package dp;
  public class MaximumProductSubarray {
      public static void main(String[] args) {
           Solution solution = new MaximumProductSubarray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        // d[i] = Math.max(d[i-1]*nums[i], nums[i]) -- 错误,因为不满足最优子结构，即当前的最优解不一定由前一个得出
        // 因此要分当前位置是正负的情况去讨论
        // 我们可以维护两个dp数组，dp_max代表乘积最大的，dp_代表乘积最小的
        // 如果当前位置是正数，我们会希望乘上前面乘积最大的，并且值越大越好
        // 如果当前位置是负数，我们会希望找到前面也是个负数，并且值越小越好
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur_max = max;
            int cur_min = min;
            max = Math.max(Math.max(cur_max * nums[i], nums[i]), cur_min * nums[i]);
            min = Math.min(Math.min(cur_min * nums[i], nums[i]), cur_max * nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }