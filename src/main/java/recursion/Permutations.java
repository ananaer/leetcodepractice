//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
          List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3, 4});
          System.out.println(permute);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public List<List<Integer>> permute(int[] nums) {
              List<List<Integer>> res = new ArrayList<>();
              // FIXME: 2020/8/29 可用Set换取时间
              backtrack(res, new ArrayList<Integer>(), nums);
              return res;
          }

          private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums) {
              if (tmp.size() == nums.length) {
                  res.add(new ArrayList<Integer>(tmp));
              } else {
                  for (int i = 0; i < nums.length; i++) {
                      if (tmp.contains(nums[i])) {
                          continue;
                      }
                      tmp.add(nums[i]);
                      backtrack(res, tmp, nums);
                      tmp.remove(tmp.size() - 1);
                  }
              }
          }

      }
}
//leetcode submit region end(Prohibit modification and deletion)

