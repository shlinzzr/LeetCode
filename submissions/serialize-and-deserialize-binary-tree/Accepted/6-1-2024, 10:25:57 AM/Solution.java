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

        s_helper(sb ,root);

        return sb.toString();
        
    }


    private void s_helper(StringBuilder sb, TreeNode node){
        if(node==null){
            sb.append("null,");
            return;
        }

        sb.append(node.val);
        sb.append(",");

        s_helper(sb, node.left);
        s_helper(sb, node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        
        return des_helper(q);
        
    }

    private TreeNode des_helper(Queue<String> q){

        if(q.isEmpty()) return null;

        String p = q.poll();
        if("null".equals(p)) return null;

        TreeNode node = new TreeNode(Integer.parseInt(p));
        node.left = des_helper(q);
        node.right = des_helper(q);

        return node;



    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));