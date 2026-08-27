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
    int maxValue = Integer.MIN_VALUE ;
    public int maxPath(TreeNode root){
       if(root == null ){
            return 0;
        }

        int left = maxPath(root.left);
        int right = maxPath(root.right);
        int maxAnswerAtMost1Subtree  = Math.max(root.val,root.val + Math.max(left,right));
        maxValue = Math.max(maxValue, 
        Math.max(root.val + left + right,maxAnswerAtMost1Subtree));
        return maxAnswerAtMost1Subtree;
    }
    public int maxPathSum(TreeNode root) {
         int mp = maxPath(root);
         return maxValue;
    }
}
