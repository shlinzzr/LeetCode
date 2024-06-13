// https://leetcode.com/problems/all-possible-full-binary-trees

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
    int total;
    int cnt = 0 ;
    List<TreeNode> res;
    public List<TreeNode> allPossibleFBT(int n) {
        
        this.total=n;
        
        res = new ArrayList<>();
        TreeNode root = new TreeNode(0);
        cnt++;
        if(n==1){
            res.add(root);
             return res;
        }
        //n=7
        //i = 1, 3, 5
        
        
//         0
//        0   0
//       0 0 x x
//      0 0      
        
        
        for(int i=1; i<=n-2; i+=2){
            // System.out.println(i + " " + (n-1-i));
            TreeNode left = helper(i);
            TreeNode right = helper(n-1-i);
            root.left = left;
            root.right = right;
            
            res.add(root);
        }
        
        return res;
        
    }
    
    private TreeNode helper(int n){
        
        TreeNode root = new TreeNode(0);
        
        if(n==1) return root;

        for(int i=1; i<=n-2; i+=2){
            TreeNode left = helper(i);
            TreeNode right = helper(n-1-i);
            
            root.left = left;
            root.right = right;
        }
        return root;
        
    }
}

//[[0,0,0,0,0,null,null,0,0],[0,0,0,0,0,null,null,0,0],[0,0,0,0,0,null,null,0,0]]

//[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]

// [[0,0,0]]