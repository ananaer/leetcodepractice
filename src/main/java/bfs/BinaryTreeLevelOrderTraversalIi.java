//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索

package bfs;

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi {
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        Stack<List<Integer>> stack = new Stack<>();
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
            stack.push(cur);
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }