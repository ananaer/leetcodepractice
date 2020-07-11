//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

package tree;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 整体思路 先从先序遍历中找到根节点
        // 在从中序遍历中找到根节点确定根节点的左子树与右子树
        // 对左子树右子树递归此过程
        HashMap<Integer, Integer> inOrder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrder.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length , inOrder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, HashMap<Integer, Integer> inOrder, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return null;
        }
        int root = preorder[preStart];
        // 找到根节点在中序遍历中的位置
        int rootIndex = inOrder.get(root);
        TreeNode rootTree = new TreeNode(root);
        int leftLength = rootIndex - inStart + 1;
        TreeNode left = buildTree(preorder, preStart + 1, preStart + leftLength, inOrder, inStart, rootIndex);
        TreeNode right = buildTree(preorder, preStart + leftLength, preEnd, inOrder, rootIndex + 1, inEnd);
        rootTree.left = left;
        rootTree.right = right;
        return rootTree;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }