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
        System.out.println(sb.toString());
        
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
    
    
    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
    }
    
    // Use queue to simplify position move
    private TreeNode deserial(Queue<String> q) {
        String val = q.poll();
        if ("null".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    }
    

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         String[] arr = data.split(",");
//         if(arr.length==0)
//             return null;
        
//         TreeNode root = deserializeHelper(root, arr);
        
//         return root;
//     }
    
//     private TreeNode deserializeHelper(TreeNode root, String[] arr){
//         if(root==null)
//             return null;
//     }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));