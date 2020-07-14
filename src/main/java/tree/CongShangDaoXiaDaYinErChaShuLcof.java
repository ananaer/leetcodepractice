//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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

package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuLcof {
      public static void main(String[] args) {
           Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
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
    public int[] levelOrder(TreeNode root) {
        // 水题 层序遍历
        if(root == null){
            return new int[0];
        }
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.pollFirst();
            resultList.add(cur.val);
            if(cur.left != null){
                queue.addLast(cur.left);
            }
            if(cur.right != null){
                queue.addLast(cur.right);
            }
        }
        int[] res = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            res[i] = resultList.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }