// https://leetcode.com/problems/correct-a-binary-tree

class Solution {
    Set<Integer> visited = new HashSet<>();
    
    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.right != null && visited.contains(root.right.val)) return null;
        visited.add(root.val);
        root.right = correctBinaryTree(root.right);
        root.left = correctBinaryTree(root.left);
        return root;
    }
}