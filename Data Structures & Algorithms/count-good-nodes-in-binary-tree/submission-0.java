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
    private int  count = 0 ;
    private int getCount(){
       return count;
    }
    private void updateCount(){
        ++count;
    }
    public void goodNodes(TreeNode root, Integer mxVal){
        if(root == null){
            return ;
        }
        if(root.val >= mxVal){
          updateCount();
        }
        goodNodes(root.left,Math.max(mxVal,root.val));
        goodNodes(root.right,Math.max(mxVal,root.val));
    } 
    public int goodNodes(TreeNode root) {
        goodNodes(root,-101);
        return getCount();
    }
}
