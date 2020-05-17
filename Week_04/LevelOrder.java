package algorithmtraining.fourthweek;

import DataStructureImplementation.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static DataStructureImplementation.CreateBinaryTree.creatTree;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 */
public class LevelOrder {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(
                1, 2, 4, null, null, 5, 7, null, null,
                null, 3, 6, null, 8, null, null, null));
        TreeNode treeNode = creatTree(inputList);
        levelOrder(treeNode);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!deque.isEmpty()) {
            int len = deque.size();
            List<Integer> temp = new ArrayList<>();
            while (len > 0) {
                TreeNode t = deque.poll();
                if (t != null) {
                    temp.add(t.val);
                    deque.add(t.left);
                    deque.add(t.right);
                }
                len--;
            }
            ans.add(temp);
        }
        return ans;
    }

}
