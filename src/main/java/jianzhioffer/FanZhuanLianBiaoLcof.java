//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表

package jianzhioffer;
  public class FanZhuanLianBiaoLcof {
      public static void main(String[] args) {
           Solution solution = new FanZhuanLianBiaoLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public MergeTwoSortedLists.Solution.ListNode reverseList(MergeTwoSortedLists.Solution.ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        MergeTwoSortedLists.Solution.ListNode p = reverseList(head.next);
        // 这两部是反转的关键
        // 假设输入是 1->2->3->4->5->NULL
        // 此时p = 5节点返回,head = 4

        // 这一步使得4 ->5->4
        head.next.next = head;
        // 这一步打断4->5 只剩下了5->4
        head.next = null;
        // 最后递归解决
        return p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }