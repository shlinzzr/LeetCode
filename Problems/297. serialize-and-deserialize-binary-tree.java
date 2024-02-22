// https://leetcode.com/problems/serialize-and-deserialize-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder sb = new StringBuilder();
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        serialHelper(root);
        return sb.toString();
    }
    
    private void serialHelper(TreeNode root){
        if(root==null){
            sb.append("null,");
            return;
        }
        
        sb.append(root.val+",");
        serialHelper(root.left);
        serialHelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeHelper(new LinkedList<>(Arrays.asList(data.split(",")))); 
    }
    
    private TreeNode deserializeHelper(Queue<String> q){
        
        if(q.isEmpty()) return null;
        
        String p = q.poll();
        
        if(p.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(p));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));