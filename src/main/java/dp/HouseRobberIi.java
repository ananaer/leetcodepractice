//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划

package dp;

public class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            // 整体思路跟打家劫舍1是一致的
            // 只要区分三种情况：1.第一间和最后一间屋子都不抢
            //                   2.抢第一间，不抢最后一间
            //                   3.不抢第一间，抢最后一间
            // 然后比较三种情况，选择最大值就行了，其实第一种的情况被2,3种覆盖
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(doRob(nums, 0, nums.length - 2), doRob(nums, 1, nums.length - 1));
        }

        private int doRob(int[] nums, int start, int end) {
            int dp_2 = 0;
            int dp_1 = 0;
            int result = 0;
            for (int i = end; i >= start; i--) {
                result = Math.max(nums[i] + dp_2, dp_1);
                dp_2 = dp_1;
                dp_1 = result;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}