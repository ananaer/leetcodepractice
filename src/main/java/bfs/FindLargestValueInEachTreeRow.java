//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索

package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindLargestValueInEachTreeRow {
      public static void main(String[] args) {
           Solution solution = new FindLargestValueInEachTreeRow().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        // 采用bfs遍历
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            // 当前层的节点数
            int levelSize = deque.size();
            Integer levelMaxValue = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = deque.removeFirst();
                levelMaxValue = Math.max(levelMaxValue, treeNode.val);
                if (null != treeNode.left) deque.addLast(treeNode.left);
                if (null != treeNode.right) deque.addLast(treeNode.right);
            }
            res.add(levelMaxValue);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }