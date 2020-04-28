//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length <= 0) {
                return result;
            }
            dfs(result, nums, new ArrayList<Integer>(), 0);
            return result;
        }

        /**
         * 回溯法
         * @param result 最后的结果
         * @param nums
         * @param tmp 中间存储的数组
         * @param index
         */
        private void dfs(List<List<Integer>> result, int[] nums, ArrayList<Integer> tmp, int index) {
            // 一上来先写模板--终止条件
            if (index == nums.length) {
                result.add(new ArrayList<>(tmp));
                return;
            }

            // 主要思路，要么选当前下标的元素 要么不选

            // 不选当前元素
            dfs(result, nums, tmp, index + 1);

            tmp.add(nums[index]);

            // 选当前元素
            dfs(result, nums, tmp, index + 1);

            // 最后要reverse 因为tmp不是本地方法的变量，而是参数，需要消除本层对于参数的改变
            tmp.remove(tmp.size() - 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}