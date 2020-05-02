//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

package bfs;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        treeNodeDeque.add(root);
        while (!treeNodeDeque.isEmpty()) {
            // 当前层的节点数量
            int size = treeNodeDeque.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeDeque.removeFirst();
                cur.add(treeNode.val);
                if (null != treeNode.left) treeNodeDeque.addLast(treeNode.left);
                if (null != treeNode.right) treeNodeDeque.addLast(treeNode.right);
            }
            res.add(cur);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }