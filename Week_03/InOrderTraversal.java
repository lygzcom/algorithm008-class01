package algorithmtraining.thirdweek;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        InOrderTraverseNonRecursive(root, list);
        return list;
    }

    public static void InOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        InOrderTraverse(root.left, list);
        list.add(root.val);
        InOrderTraverse(root.right, list);

    }

    public static void InOrderTraverseNonRecursive(TreeNode root, List<Integer> list) {
        Stack<TreeNode> s = new Stack();
        TreeNode p = root;
        TreeNode temp;
        while (p != null || !s.empty()) {
            if (p != null) {
                s.push(p);//根节点入栈
                p = p.left;//遍历左子树
            } else {
                temp = s.pop();
                list.add(temp.val);//访问根节点
                p = temp.right;//遍历右子树
            }
        }

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
