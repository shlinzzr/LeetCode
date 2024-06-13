// https://leetcode.com/problems/serialize-and-deserialize-bst

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

        if(root==null) return "null,";

        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
        
    }

    private void serializeHelper(TreeNode node, StringBuilder sb){

        if(node==null) {
            sb.append("null,");
        }else{
            sb.append(node.val + ",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(q);
        
        
    }

    private TreeNode deserializeHelper(Queue<String> q ){

        if(q.isEmpty()) return null;
        String p = q.poll();
        if("null".equals(p)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(p));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;