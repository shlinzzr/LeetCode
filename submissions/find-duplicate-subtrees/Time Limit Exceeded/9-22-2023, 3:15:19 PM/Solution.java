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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();

        HashMap<Integer, List<TreeNode>> map = new HashMap<>();

        helper(root, map, res);

        return res;

    }

    private void helper(TreeNode root, HashMap<Integer, List<TreeNode>> map  , List<TreeNode> res ){
        if(root==null)
            return;

        if(map.containsKey(root.val)){
            List<TreeNode> list = map.get(root.val);
            for(TreeNode node : list){
                if(isSameTree(node, root) && !isContain(res, root)){
                    res.add(root);
                    break;
                }
                    
            }
        }

        map.putIfAbsent(root.val, new ArrayList<>());
        map.get(root.val).add(root);

        if(root.left!=null)
            helper(root.left, map, res);

        if(root.right!=null)            
            helper(root.right, map, res);



    }

    private boolean isContain(List<TreeNode> res, TreeNode a){

        for(TreeNode t: res){
            if(isSameTree(a, t))
                return true;
        }
        return false;

    }


    private boolean isSameTree(TreeNode a, TreeNode b){
        
        if(a==null && b==null)
            return true;

        if(a==null || b==null || a.val!=b.val) 
            return false;

        boolean left = isSameTree(a.left, b.left);
        boolean right = isSameTree(a.right, b.right);

        return left && right;
    }
}