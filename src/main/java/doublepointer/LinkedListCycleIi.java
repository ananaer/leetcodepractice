//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针

package doublepointer;

import jianzhioffer.CongWeiDaoTouDaYinLianBiaoLcof.*;

public class LinkedListCycleIi {
      public static void main(String[] args) {
           Solution solution = new LinkedListCycleIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 双指针 快慢指针 快指针一次走两步 慢指针一次走一步，
        // 如果链表存在环的话快指针一定会追上慢指针，因为快指针每次都会比慢指针多走一步，存在环说明就会一直走下去，直到快==慢
        // 先判断链表是否有环
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        // 设链表头到入环点的步数为a , 环内的步数为b
        // fast 走的步数是slow步数的 2 倍，即 f = 2s
        // fast 比 slow多走了 n 个环的长度，即 f = s + nb；
        // 两式相减得 s = nb ,这时再指定一个指针p1从head开始走
        // 那p1走了a步 此时s = a+nb  此时p1与slow相遇 p1刚好是入环点
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }