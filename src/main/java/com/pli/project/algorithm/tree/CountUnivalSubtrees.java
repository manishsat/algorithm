package com.pli.project.algorithm.tree;

/**
 * Created by lipeng on 2016/1/25.
 * LeetCode: Count Univalue Subtrees
 Given a binary tree, count the number of uni-val subtrees.

 A Uni-val subtree means all nodes of the subtree have the same val.

 For example:

 Given binary tree,

      5
    / \
   1   5
  / \   \
 5   5   5
 */
public class CountUnivalSubtrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int countUnivalSubtrees(TreeNode root) {
        int[] ans = countUnivalSubtreesHelper(root);
        return ans[1];
    }

    // return [val, count], if root is not a unival subtree, then val is Integer.MIN_VALUE.
    public static int[] countUnivalSubtreesHelper(TreeNode root) {
        if (root == null) {
            return new int[] {Integer.MIN_VALUE, 0};
        }
        int[] left = countUnivalSubtreesHelper(root.left);
        int[] right = countUnivalSubtreesHelper(root.right);
        // count current val only when its val both equal to its descendant, or it is a leaf node
        if (left[0] == root.val && right[0] == root.val || left[0] == Integer.MIN_VALUE && right[0] == Integer.MIN_VALUE)
            return new int[] {root.val, left[1] + right[1] + 1};
        else
            return new int[] {Integer.MIN_VALUE, left[1] + right[1]};
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(5);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.right = t6;
        System.out.println(countUnivalSubtrees(t1));
    }

}
