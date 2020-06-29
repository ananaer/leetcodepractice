//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法

package recursion;

import java.util.*;

public class PermutationsIi {
      public static void main(String[] args) {
           Solution solution = new PermutationsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public List<List<Integer>> permuteUnique(int[] nums) {
              List<List<Integer>> res = new ArrayList<>();
              Arrays.sort(nums);
              boolean[] used = new boolean[nums.length];
              backtrack(res, new ArrayList<Integer>(), nums, used);
              return res;
          }
          private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] used) {
              if (tmp.size() == nums.length) {
                  res.add(new ArrayList<Integer>(tmp));
              } else {
                  for (int i = 0; i < nums.length; i++) {
                      /*The difficulty is to handle the duplicates.
                              With inputs as [1a, 1b, 2a],
                      If we don't handle the duplicates, the results would be: [1a, 1b, 2a], [1b, 1a, 2a]...,
                      so we must make sure 1a goes before 1b to avoid duplicates
                      By using nums[i-1]==nums[i] && !used[i-1], we can make sure that 1b cannot be choosed before 1a*/
                      if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                          continue;
                      }
                      tmp.add(nums[i]);
                      used[i] = true;
                      backtrack(res, tmp, nums,used);
                      tmp.remove(tmp.size() - 1);
                      used[i] = false;
                  }
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }