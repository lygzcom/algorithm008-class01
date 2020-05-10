package algorithmtraining.thirdweek;

import DataStructureImplementation.CreateBinaryTree;
import DataStructureImplementation.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {
    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(1, 1, null, null, null));
        TreeNode t = CreateBinaryTree.creatTree(inputList);
        isValidBST(t);
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

    }

    public static boolean isValidBST(TreeNode root) {
        return fun(root, null, null);
    }
    //利用每个节点值都大于左子树的值，小于右子树的值
    //构造递归函数

    public static Boolean fun(TreeNode T, Integer low, Integer high) {
        if (T == null) {
            return true;
        }
        if (low != null && T.val <= low) return false;
        if (high != null && T.val >= high) return false;
        return fun(T.left, low, T.val) && fun(T.right, T.val, high);

    }

    public long pre = Long.MIN_VALUE;

    //利用中序遍历结果是递增序列判断
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
