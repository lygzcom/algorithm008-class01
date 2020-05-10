package algorithmtraining.thirdweek;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderTraverseNonRecursive(root, list);
        return list;
    }

    public static void postOrderTraverseNonRecursive(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return;
        }
        TreeNode cur, pre = null;
        stack.push(root);
        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (cur.left == pre || cur.right == pre))) {
                TreeNode temp = stack.pop();
                list.add(temp.val);
                pre = temp;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }

    }

    public static void postOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.left, list);
        postOrderTraverse(root.right, list);
        list.add(root.val);

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
