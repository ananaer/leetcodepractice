//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
      public static void main(String[] args) {
           Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
    public List<Integer> preorderTraversal(TreeNode root) {
// 非递归版本
        List<Integer> res = new ArrayList();
        Deque<TreeNode> stack = new LinkedList();
        while(root != null){
            res.add(root.val);
            if(root.right != null){
                stack.addLast(root.right);
            }
            root = root.left;
            if(root == null && !stack.isEmpty()){
                root = stack.pollLast();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }