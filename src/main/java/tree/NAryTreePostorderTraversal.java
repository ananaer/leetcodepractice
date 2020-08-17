//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树

package tree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorder(Node root) {
            if (root == null) return Collections.emptyList();
            LinkedList<Integer> res = new LinkedList();
            Deque<Node> stack1 = new LinkedList();
            stack1.addLast(root);
            while (!stack1.isEmpty()) {
                Node top = stack1.pollLast();
                res.addFirst(top.val);
                if (top.children != null) {
                    for (int i = 0; i < top.children.size(); i++) {
                        stack1.addLast(top.children.get(i));
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}