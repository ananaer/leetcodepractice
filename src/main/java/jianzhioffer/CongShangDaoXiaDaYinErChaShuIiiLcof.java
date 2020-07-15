//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
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
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索

package jianzhioffer;


import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList();
            if (root == null) {
                return res;
            }
            Deque<TreeNode> queue = new LinkedList();
            queue.addLast(root);
            boolean isOrder = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> curList = new ArrayList();

                while (size > 0) {
                    TreeNode curNode = isOrder ? queue.pollFirst() : queue.pollLast();
                    curList.add(curNode.val);
                    if (isOrder) {
                        if (curNode.left != null) {
                            queue.addLast(curNode.left);
                        }
                        if (curNode.right != null) {
                            queue.addLast(curNode.right);
                        }
                    } else {
                        if (curNode.right != null) {
                            queue.addFirst(curNode.right);
                        }
                        if (curNode.left != null) {
                            queue.addFirst(curNode.left);
                        }
                    }
                    size--;
                }
                isOrder = !isOrder;
                res.add(curList);

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}