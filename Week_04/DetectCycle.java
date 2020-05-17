package algorithmtraining.fourthweek;

import algorithmtraining.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode h = createList(new int[]{1, 2}, -1);
        System.out.println(detectCycle1(h));
    }

    public static ListNode createList(int[] nums, int z) {
        ListNode h = new ListNode(-1);
        ListNode p = h;
        ListNode f = null;
        int i = 0;
        for (int x : nums) {
            ListNode n = new ListNode(x);
            p.next = n;
            p = n;
            if (i == z) {
                f = n;
            }
            i++;
        }
        p.next = f;
        return h.next;
    }

    /**
     * 判断链表是否有环
     * 1、记录访问过的节点，节点再次出现表示链表有环，且此节点就是环的入口
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return head;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 快慢指针判断有环
     * 数学证明可以找到入口 s慢指针走的路程，L环长
     * fast=2*s
     * fast=s+n*L 快指针比慢指针多走了n个环的距离
     * s=n*L       算出 相遇时慢指针一共走了n个环的距离
     * 设k为走到环入口的步数,不包含入口，k=a+m*L (m>=0)，s已经走过n个环的距离，再走a步就可以再次达到环的入口
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (flag) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }

}
