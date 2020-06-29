//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi {
      public static void main(String[] args) {
           Solution solution = new SubsetsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public List<List<Integer>> subsetsWithDup(int[] nums) {
              List<List<Integer>> res = new ArrayList<>();
              Arrays.sort(nums);
              backTrack(res,nums, new ArrayList<Integer>(), 0);
              return res;
          }

          private void backTrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> path, int start) {
              res.add(new ArrayList<Integer>(path));
              for (int i = start; i < nums.length; i++) {
                  if (i > start && nums[i - 1] == nums[i]) {
                      // 重复元素不选
                      continue;
                  }
                  // 要么选
                  path.add(nums[i]);
                  backTrack(res, nums, path, i + 1);

                  // 撤销选择
                  path.remove(path.size() - 1);
              }
          }
      }

//leetcode submit region end(Prohibit modification and deletion)

  }