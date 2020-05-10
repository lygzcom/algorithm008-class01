package algorithmtraining.thirdweek;

import java.util.Stack;

/**
 * leetcode 面试题06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrint {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode p = head;
        int length = 0;
        while (p != null) {
            stack.push(p);
            p = p.next;
            length++;
        }
        int[] result = new int[length];
        int i = 0;
        while (!stack.empty()) {
            p = stack.pop();
            result[i++] = p.val;
        }
        return result;
    }

}
