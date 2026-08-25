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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        q.offer(root);
        int level = 0 ; 
        while(!q.isEmpty()){
            int k = q.size();
            while(k-- > 0){
                TreeNode curr = q.poll();
                if( level == ans.size()){
                    ans.add(curr.val);
                }

                if(curr.right != null){
                    q.offer(curr.right);
                }
                if(curr.left != null){
                    q.offer(curr.left);
                }
            }
            level++;
        }
    return ans;
    }
}
