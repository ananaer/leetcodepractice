package tree;//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归实现
        List<Integer> list = new ArrayList();
        return inorderTraversalHelp(root, list);
    }

    public List<Integer> inorderTraversalHelp(TreeNode root, List<Integer> result) {
        if (null == root) {
            return result;
        }
        // 前序中序后序只是调整位置
        inorderTraversalHelp(root.left, result);
        result.add(root.val);
        inorderTraversalHelp(root.right, result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
