//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIii {
      public static void main(String[] args) {
           Solution solution = new CombinationSumIii().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public List<List<Integer>> combinationSum3(int k, int n) {
              List<List<Integer>> res = new ArrayList<>();
              backtrack(res, new ArrayList<Integer>(), k, n, 1);
              return res;
          }

          public void backtrack(List<List<Integer>> res, List<Integer> path, int k, int n, int start){
              if(n < 0){
                  return;
              }
              if(n == 0){
                  if( path.size() == k){
                      res.add(new ArrayList(path));
                  }
                  return;
              }else{
                  // 做选择 每个位置有1~9的尝试
                  for(int j = start;  j <=9 ; j++){
                      if(path.size() > k){
                          continue;
                      }
                      path.add(j);
                      backtrack(res, path, k, n-j, j + 1);
                      path.remove(path.size()-1);
                  }
              }
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }