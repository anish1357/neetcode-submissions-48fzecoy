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

public class Codec {
    TreeNode rootCopy = null;
    public void dfsSerialise(TreeNode root, List<String> values){
       if(root == null){
        values.add("N");
        return ;
       }

       values.add(String.valueOf(root.val));
       dfsSerialise(root.left, values);
       dfsSerialise(root.right, values);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       List<String> values = new ArrayList<>();
       dfsSerialise(root,values);
      return String.join(",",values);
    }

    public TreeNode dfsDeserialise(String[] values, int[] i){
        if("N".equals(values[i[0]])){
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[i[0]++]));
        node.left = dfsDeserialise(values,i);
        node.right = dfsDeserialise(values,i);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] i = {0};
        return dfsDeserialise(values,i);
    }
}
