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
    public boolean isSame(TreeNode p , TreeNode q){
        if((p == null && q == null) || (p != null && q != null)){
            
                        
            if(p == null){
                return true;
            }
            if(p.val != q.val){
                return false;
            }

           boolean left = isSame(p.left,q.left);
           boolean right = isSame(p.right,q.right);
           return left && right;

        } else {
            return false;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }
}
