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
        serialHelper(root, sb);
        return sb.toString();
    }
    
    private void serialHelper(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }
        
        sb.append(root.val).append(",");
        serialHelper(root.left, sb);
        serialHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialHelper(new LinkedList<>(Arrays.asList(data.split(","))));
    }
    
    private TreeNode deserialHelper(Queue<String> q){
        
        // if(q.isEmpty())
        //     return null;
        
         String val = q.poll();
        if ("null".equals(val)) return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserialHelper(q);
        root.right = deserialHelper(q);
        return root;
            
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));