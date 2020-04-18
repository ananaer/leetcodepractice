package tree;//����һ���������������������� ������
//
// ʾ��:
//
// ����: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//���: [1,3,2]
//
// ����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����
// Related Topics ջ �� ��ϣ��


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
        // �ݹ�ʵ��
        List<Integer> list = new ArrayList();
        return inorderTraversalHelp(root, list);
    }

    public List<Integer> inorderTraversalHelp(TreeNode root, List<Integer> result) {
        if (null == root) {
            return result;
        }
        // ǰ���������ֻ�ǵ���λ��
        inorderTraversalHelp(root.left, result);
        result.add(root.val);
        inorderTraversalHelp(root.right, result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
