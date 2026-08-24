/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public TreeNode invert(TreeNode root){
        if(root == null){
            return root;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invert(root.left);
        invert(root.right);
        return root;

    }
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
}
