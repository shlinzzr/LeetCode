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
        
        List<String> list = new ArrayList<>();
        helper(root, list);
        
        for(int i=0; i<list.size(); i++){
            if(i==0)
                sb.append("[");
            else{
                sb.append(",");
            }
            
            sb.append(list.get(i));
        }
        
        sb.append("]");
        
        return sb.toString();
    }
    
    private void helper(TreeNode root, List<String> list){
        if(root==null){
            list.add("null");
            return;
        }
        
        list.add(String.valueOf(root.val));
        helper(root.left);
        helper(root.right);
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length()-1);
        String[] arr = data.split(",");
        
        if(arr.length==0)
            return null;
        
        TreeNode root = new TreeNode(arr[0]);
        helper(root, arr);
        
        return root;
    }
    
    private void helper(TreeNode root, String[] arr){
        if(root==null)
            return;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));