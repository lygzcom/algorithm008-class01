package algorithmtraining.thirdweek;

import DataStructureImplementation.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
    }

    /**
     * 思考：如果root为空 return null;
     * 否则只存在以下三种情况
     * 1、根节点==p||q  没有更高的祖先节点  返回根节点
     * 2、p和q分布在根节点的左右子树上  那么根节点就是唯一的公共祖先
     * 3、p和q都在根节点的一个子树上，先找到的节点就是p q的最近公共祖先
     * （就是问题被缩小为一个子问题，考虑最简单的只有两个和三个节点时就可以递归解决）
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    /**
     * 找出两个节点的所有祖先序列，找到最后一个相同的节点就是最近公共祖先；
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        getAncestors(root, p, q, new ArrayList<>());
        int i = 0;
        while (i < pAncestors.size() && i < qAncestors.size() && pAncestors.get(i) == qAncestors.get(i)) {
            i++;
        }
        return pAncestors.get(i - 1);
    }

    public List<TreeNode> pAncestors = new ArrayList<>();
    public List<TreeNode> qAncestors = new ArrayList<>();

    public void getAncestors(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> ancestors) {
        if (root == null) {
            return;
        }
        ancestors.add(root);
        if (root == p) {
            pAncestors = new ArrayList<>(ancestors);
        }
        if (root == q) {
            qAncestors = new ArrayList<>(ancestors);
        }
        getAncestors(root.left, p, q, ancestors);
        getAncestors(root.right, p, q, ancestors);
        ancestors.remove(ancestors.size() - 1);
    }

}
