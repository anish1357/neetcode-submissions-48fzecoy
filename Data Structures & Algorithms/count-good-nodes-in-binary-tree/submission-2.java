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
    public int goodNodes(TreeNode root, Integer mxVal){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.val >= mxVal){
          count++;
        }
        count += goodNodes(root.left,Math.max(mxVal,root.val));
        count += goodNodes(root.right,Math.max(mxVal,root.val));
        return count;
    } 
    public int goodNodes(TreeNode root) {
        
        return goodNodes(root,-101);
    }
}
