//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
      public static void main(String[] args) {
           Solution solution = new CombinationSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), target, candidates, 0);
        return res;
    }

          private void backtrack(List<List<Integer>> res, List<Integer> tmp, int curVal, int[] candidates, int start) {
              if (curVal < 0) {
                  return;
              } else if (curVal == 0) {
                  res.add(new ArrayList<Integer>(tmp));
              } else {
                  for (int i = start; i < candidates.length; i++) {
                      tmp.add(candidates[i]);
                      backtrack(res, tmp, curVal - candidates[i], candidates, i);
                      tmp.remove(tmp.size() - 1);
                  }
              }
          }

      }
//leetcode submit region end(Prohibit modification and deletion)

  }