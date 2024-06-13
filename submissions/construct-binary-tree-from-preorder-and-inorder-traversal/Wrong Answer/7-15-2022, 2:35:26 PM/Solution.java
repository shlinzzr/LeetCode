// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
         Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
         Map<Integer, Integer> preMap = new HashMap<Integer, Integer>();
         for(int i = 0; i < preorder.length; i++) {
            preMap.put(preorder[i], i);
        }
        
        
        
        return buildTree(preorder, inorder, preMap, inMap);
    }
        
    private TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer>preMap, Map<Integer, Integer>inMap) {
        
        
        int rootVal = preorder[0];
        

        if(preorder.length==1){
            TreeNode head = new TreeNode(rootVal);
            return head;
        }
        
        
        int left = inMap.get(rootVal) - preMap.get(rootVal);
        int right = inorder.length-left -1;
        // System.out.println(left + " , " + right + " root:"+rootVal);
        
         TreeNode leftNode = left <=0 ? null :  buildTree(Arrays.copyOfRange(preorder, 1, left+1)
                                                          , Arrays.copyOfRange(inorder, 0, left), preMap, inMap);
        
        TreeNode rightNode = right <=0 ? null : buildTree(Arrays.copyOfRange(preorder, left+1, inorder.length),                                                                   Arrays.copyOfRange(inorder, left+1, inorder.length), preMap, inMap);
        
      
        
        TreeNode head = new TreeNode(rootVal, leftNode , rightNode);
                                     
        
        
        return head;
    }
    
}