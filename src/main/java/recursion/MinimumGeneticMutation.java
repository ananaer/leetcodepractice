//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意: 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 所有的目标基因序列必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 示例 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
//

package recursion;

import java.util.HashSet;
import java.util.Set;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new MinimumGeneticMutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Integer cout = Integer.MAX_VALUE;
        public int minMutation(String start, String end, String[] bank) {
            // 问题转化为dfs,遍历每种可能性，看是否有与目标字符串相等的
            dfs(start, end, 0, bank, new HashSet<String>());
            return cout == Integer.MAX_VALUE ? -1 : cout;
        }

        private void dfs(String start, String end, int level, String[] bank, Set<String> visited) {
            if (start.equals(end)) {
                cout = Math.min(cout, level);
            }
            for (String s : bank) {
                // 判断当前库的字符串是否start的差异
                int diff = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (start.charAt(i) != s.charAt(i)) {
                        diff ++;
                    }
                    if (diff > 1) {
                        break;
                    }
                }
                // 只有当只相差一个字符 并且 没有被遍历过时 探到下一层
                if (diff == 1 && !visited.contains(s)) {
                    visited.add(s);
                    dfs(s, end, level + 1, bank, visited);
                    // 消除本层的影响
                    visited.remove(s);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}