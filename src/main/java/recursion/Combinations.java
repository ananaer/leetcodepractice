//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            trackBack(res, new HashSet<Integer>(), n, k,1);
            return res;
        }

        private void trackBack(List<List<Integer>> res, Set<Integer> tmpList, int n, int k, int start) {
            if (tmpList.size() == k) {
                res.add(new ArrayList<Integer>(tmpList));
            }
            for (int i = start; i <= n; i++) {
                if (tmpList.contains(i)) {
                    continue;
                }
                tmpList.add(i);
                // 一个元素只能用一次 所以i+1
                trackBack(res, tmpList, n, k, i + 1);
                tmpList.remove(i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}