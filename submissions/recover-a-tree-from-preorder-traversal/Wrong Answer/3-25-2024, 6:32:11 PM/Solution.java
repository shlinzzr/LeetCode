// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal

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
    int leftNum=0, rightNum=0;
    List<int[]> list = new ArrayList<>();

    public TreeNode recoverFromPreorder(String t) {

        int len = t.length();

        for (int i=0; i<len; i++){
            int j = i;
            while (j<len && t.charAt(j)=='-')
                j++;
            int depth = j-i;
            i = j;
            while (j<len && Character.isDigit(t.charAt(j)))
                j++;
            
            int val = Integer.valueOf(t.substring(i, j));
            list.add(new int[]{val,Math.max(0, depth) });
            i = j-1;
        }
        int num = 0;
        return DFS(0);
    }

    private TreeNode DFS(int cur)
    {
        TreeNode root = new TreeNode(list.get(cur)[0]);
        if (cur+1 < list.size() && list.get(cur+1)[1] == list.get(cur)[1]+1)
        {
            TreeNode left = DFS(cur+1);
            root.left = left;
        }        
        if (cur+leftNum+1 < list.size() && list.get(cur+leftNum+1)[1] == list.get(cur)[1]+1)
        {
            TreeNode right = DFS(cur+leftNum+1);
            root.right = right;
        }
        return root;
    }
}