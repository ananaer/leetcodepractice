//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {
      public static void main(String[] args) {
           Solution solution = new CombinationSumIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public List<List<Integer>> combinationSum2(int[] candidates, int target) {
              List<List<Integer>> res = new ArrayList<>();
              Arrays.sort(candidates);
              trackBack(res, new ArrayList<Integer>(), candidates, target, 0);
              return res;
          }

          private void trackBack(List<List<Integer>> res, List<Integer> tmpList, int[] candidates, int target, int start) {
              if (target < 0) {
                  return;
              } else if (target == 0) {
                  res.add(new ArrayList<>(tmpList));
              } else {
                  for (int i = start; i < candidates.length; i++) {
                      // 什么时候我们应该跳过重复值呢？--如何避免使用重复元素
                      // 当i>start时说明candidates[i]这个数没有被加到前面路径中，并且如果它又等于前一个值 就证明是重复
                      if (i > start && candidates[i] == candidates[i - 1]) {
                          continue;
                      }
                      tmpList.add(candidates[i]);
                      // i + 1 表示一个元素只能使用一次
                      trackBack(res, tmpList, candidates, target - candidates[i], i + 1);
                      tmpList.remove(tmpList.size()-1);
                  }
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }