// https://leetcode.com/problems/find-duplicate-subtrees

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
    Map<String, Integer> map = new HashMap<>();
    Set<TreeNode> res = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        if(root==null) return new ArrayList<>();
        serialize(root);
        return new ArrayList<>(res);
    }

    private String serialize(TreeNode node){
        // StringBuilder sb = new StringBuilder();
        // serializeHelper(node, sb);
        if(node==null) return "null,";


        String left =  serialize(node.left);
        String right =  serialize(node.right);
        String serial = node.val + "," + left + ","+ right;

        // if(node.left!=null) serialize(node.left);
        // if(node.right!=null) serialize(node.right);

        if(map.containsKey(serial) && map.get(serial)==1) 
            res.add(node);
        map.put(serial, map.getOrDefault(serial, 0)+1);

        return serial;
    }

    private void serializeHelper(TreeNode node, StringBuilder sb){
        if(node==null){
            sb.append("null,");
            
        } else{
            sb.append(node.val+",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }

    }
}