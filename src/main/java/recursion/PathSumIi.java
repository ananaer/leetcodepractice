//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索

package recursion;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi {
      public static void main(String[] args) {
           Solution solution = new PathSumIi().new Solution();
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        dfs(res, sum, new ArrayList(), root);
        return res;
    }

    public void dfs(List<List<Integer>> res, Integer cur, List<Integer> path, TreeNode root){
        if(root == null){
            return;
        }
        if(cur - root.val == 0 && root.left == null && root.right == null){
            List<Integer> tmp = new ArrayList(path);
            tmp.add(root.val);
            res.add(tmp);
        }else {
            path.add(root.val);
            dfs(res,cur - root.val, path, root.left);
            dfs(res,cur - root.val, path, root.right);
            path.remove(path.size() - 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }