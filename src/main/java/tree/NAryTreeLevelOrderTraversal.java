//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        // 这题是层序遍历，也就是广度优先使用队列先进先出的特性解决，记忆题
        // 时间复杂度空间复杂度都是O(N)
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<Integer>();
            int size = queue.size();
            // 记录这一层的结果
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                curList.add(poll.val);
                queue.addAll(poll.children);
            }
            result.add(curList);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }