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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        sehelper(root, sb);
        return sb.toString();
    }
    
    
    private void sehelper(TreeNode root, StringBuilder sb){
        
        if(root==null){
            sb.append("null,");
            return;
        }
            
        sb.append(root.val).append(",");
        sehelper(root.left, sb);
        sehelper(root.right, sb);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = dehelper(new LinkedList<>( Arrays.asList(data.split(","))));
        return root;
    }
    
    
    private TreeNode dehelper(Queue<String> q){
        
        if(q.isEmpty()){
            return null;
        }
        
        String val = q.poll();
        if("null".equals(val))
            return null;
        
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = dehelper(q);
        node.right = dehelper(q);
        
        return node;
        
        
        
    
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));