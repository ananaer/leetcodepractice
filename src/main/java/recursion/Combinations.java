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
        solution.combine(4, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            trackBack(res, new ArrayList<Integer>(), n, k,1);
            return res;
        }

        private void trackBack(List<List<Integer>> res, List<Integer> tmpList, int n, int k, int start) {
            // 每下一层k-- 当k为0时满足结构
            if (k == 0) {
                res.add(new ArrayList<>(tmpList));
                return;
            }
            // 为什么i的条件是n-k+1呢？
            // 当你知道后半层的数量肯定不足够K时，后面就不需要在继续回溯了
            // 比如n=10,k=5;当我们遍历到i=7时，后面只有 8 9 10 最多只有四个数 因此没必要遍历了
            for (int i = start; i <= n - k + 1; i++) {
                tmpList.add(i);
                // 一个元素只能用一次 所以i+1
                trackBack(res, tmpList, n, k - 1, i + 1);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}