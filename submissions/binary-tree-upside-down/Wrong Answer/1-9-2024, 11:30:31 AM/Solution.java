// https://leetcode.com/problems/binary-tree-upside-down

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

public class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node(){}
    Node(int val){this.val=val;}
}

class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {

        if(root==null) return null;
        TreeNode res = new TreeNode();

        Queue<TreeNode[]> q = new LinkedList<>();
        q.offer(new TreeNode[]{null, root}); // parent, curr

        while(!q.isEmpty()){
            int siz = q.size();
            boolean first = true;
            while(siz-->0){

                TreeNode[] arr = q.poll();
                TreeNode parent = arr[0]; // null
                TreeNode curr = arr[1]; // 1

                TreeNode left = curr.left;  // 2 
                TreeNode right = curr.right; // 3


                if(left!=null){
                    if(first)
                        q.offer(new TreeNode[]{curr, left});
                    else 
                        q.offer(new TreeNode[]{null, left});
                }

                if(right!=null){
                    q.offer(new TreeNode[]{null, right});
                }

                if(parent!=null)
                    curr.left = parent.right;

                if(first){
                    res = curr;//1
                    curr.right = parent;
                    if(parent!=null) parent.right=null;
                    first=false;
                }

                
            }
        }

        return res;
    
    }
}