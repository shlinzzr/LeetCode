// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree

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
class FindElements {

    HashSet<Integer> set ;
    
    public FindElements(TreeNode root) {
        root.val = 0;
        set = new HashSet<>();
        recoverTree(root);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
    
    private void recoverTree(TreeNode root){
        
        if(root==null)
            return;

        set.add(root.val);
        
        if(root.left!=null){
            root.left.val = 2 * root.val +1;
            recoverTree(root.left);
        }
        
        if(root.right!=null){
            root.right.val = 2 * root.val +2;
            recoverTree(root.right);
        }
        
    }
    
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */