//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树

package tree;
  public class ShuDeZiJieGouLcof {
      public static void main(String[] args) {
           Solution solution = new ShuDeZiJieGouLcof().new Solution();
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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 假如把题目简单改为判断B是否是以A为根节点的子结构，那么解答会很简单;而这题就是把以A为根节点变化为A树的每个节点作为根节点
        // 1.判断以节点A作为根节点的是否包含B的字结构，如果不相等再使用A的左右子树作为根节点判断，
        // 2.对于过程1递归调用就能做到根据每个节点都进行一次判断
        return (A != null && B != null) && (rec(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    // 判断是否一一匹配
    private boolean rec(TreeNode a, TreeNode b) {
        if (b == null) {
            // b等于null说明B的都匹配上了
            return true;
        }
        if (a == null) {
            return false;
        }
        return a.val == b.val && rec(a.left, b.left) && rec(a.right, b.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }