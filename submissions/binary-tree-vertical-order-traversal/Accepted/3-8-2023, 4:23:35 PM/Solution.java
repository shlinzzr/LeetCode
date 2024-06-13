// https://leetcode.com/problems/binary-tree-vertical-order-traversal

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
    
   public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> cols = new ArrayList<>();
        if (root == null) {
            return cols;
        }

        int[] range = new int[] {0, 0};
        getRange(root, range, 0);

        System.out.println(range[0] + " " + range[1]);    
    
    
        for (int i = range[0]; i <= range[1]; i++) {
            cols.add(new ArrayList<Integer>());
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        queue.add(root);
        colQueue.add(-range[0]); // because root colIdx is equal to negative min Idx

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = colQueue.poll();

            cols.get(col).add(node.val);

            if (node.left != null) {
                queue.add(node.left);   
                colQueue.add(col - 1);
            } 
            if (node.right != null) {
                queue.add(node.right);
                colQueue.add(col + 1);
            }
        }

        return cols;
    }

    public void getRange(TreeNode root, int[] range, int col) {
        if (root == null) {
            return;
        }
        range[0] = Math.min(range[0], col);
        range[1] = Math.max(range[1], col);

        getRange(root.left, range, col - 1);
        getRange(root.right, range, col + 1);
    }
}