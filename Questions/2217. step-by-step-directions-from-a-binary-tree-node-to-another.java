// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another

class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        find(root, startValue, start);
        find(root, destValue, dest);
        
        System.out.println(start.toString());
        System.out.println(dest.toString());
        
        // start.reverse();
        // dest.reverse();
        while (start.length() > 0 && dest.length() > 0 && start.charAt(0) == dest.charAt(0)) {
            start.deleteCharAt(0);
            dest.deleteCharAt(0);
        }
        return "U".repeat(start.length()) + dest.toString();
    }
    
    
    private boolean find(TreeNode root, int val, StringBuilder sb) {
        if (root.val == val) return true;
        if (root.left != null){
            sb.append("L");
            if (find(root.left, val, sb)){
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
        }
        
        
        if (root.right != null){
            sb.append("R");
            if (find(root.right, val, sb)){
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
}