// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another

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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // 拷貝難

        //anyway... 同樣先找LCA

        int st=startValue, dest = destValue;

        TreeNode lca = findLCA(root, st, dest);

        int ucnt = getDepth(root, st, 0);

        StringBuilder sb = new StringBuilder();
        while(ucnt-->0) sb.append("U");

        findDest(root, dest, sb);

        return sb.toString();
        
    }

    boolean found = false;

     
    private boolean findDest(TreeNode root, int val, StringBuilder sb) {
        if (root.val == val) return true;
        if (root.left != null){
            sb.append("L");
            if (findDest(root.left, val, sb)){
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
        }
        
        
        if (root.right != null){
            sb.append("R");
            if (findDest(root.right, val, sb)){
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }

    // private void findDest(TreeNode node, int dest, StringBuilder sb){

    //     if(node==null) return;

    //     if(node.val==dest) return;

    //     sb.append("L");
    //     findDest(node.left, dest, sb);
    //     if(found) return;

    //     sb.deleteCharAt(sb.length()-1);
    //     sb.append("R");
    //     findDest(node.right, dest, sb);
    //     if(found==false)
    //         sb.deleteCharAt(sb.length()-1);

    // }

    private int getDepth(TreeNode node, int st, int lv){
        if(node==null) return Integer.MAX_VALUE/2;

        if(node.val==st) return lv;

        int left = getDepth(node.left, st, lv+1);
        int right = getDepth(node.right,  st, lv+1);

        return Math.min(left, right);

    }


    private TreeNode findLCA(TreeNode node, int st, int dest){
        if(node==null) return null;

        if(node.val==st || node.val==dest)
            return node;
        
        
        TreeNode left = findLCA(node.left, st, dest);
        TreeNode right = findLCA(node.right, st, dest);

        if(left!=null && right!=null) return node;

        return left!=null ? left : right;
    }
}