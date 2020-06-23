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
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
          private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, Integer cur) {
              if (tmp.size() == nums.length) {
                  res.add(new ArrayList<Integer>(tmp));
              } else {
                  for (int i = 0; i < nums.length; i++) {
                      if (i > cur && nums[i] == nums[i - 1]) {
                          continue;
                      }
                      tmp.add(nums[i]);
                      backtrack(res, tmp, nums,cur++);
                      tmp.remove(tmp.size() - 1);
                  }
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }