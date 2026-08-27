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

        int left = Math.max(maxPath(root.left),0) ;
        int right = Math.max(maxPath(root.right),0);
        maxValue = Math.max(maxValue, root.val + left + right);
        return root.val + Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
         maxPath(root);
         return maxValue;
    }
}
