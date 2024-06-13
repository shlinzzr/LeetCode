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
        StringBuilder sb = new StringBuilder();
        
        helper(root, sb, startValue);
        // System.out.println(sb.toString());
        helper2(root, sb, destValue);
        
        String s = sb.toString();
        Stack<Character> st = new Stack<>();
        
        
        for(char ch : s.toCharArray()){
            
            if(ch=='R'){
                if(!st.isEmpty() && st.peek()=='r')
                    st.pop();
                else
                    st.push(ch);
            }
            
            else if(ch=='L'){
                if(!st.isEmpty() && st.peek()=='l')
                    st.pop();
                else
                    st.push(ch);
            }else{
                st.push(ch);
            }
        }
        
        String res = "";
        for(char ch : st){
            if(ch=='r' || ch=='l')
                ch='U';
            res+=ch;
        }
            
        
        return res;
        
    }
    
    private boolean helper2(TreeNode root, StringBuilder sb, int target){
        if(root==null)
            return false;
        
        if(root.val==target)
            return true;
        
        if(root.left!=null){
            sb.append("L");
            if(helper2(root.left, sb, target))
                return true;
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(root.right!=null){
            sb.append("R");
            if(helper2(root.right, sb, target))
                return true;
            sb.deleteCharAt(sb.length()-1);
        } 
        
        return false;
        
    }
    
    
    
    private boolean helper(TreeNode root, StringBuilder sb, int target){
        
        if(root==null)
            return false;
        
        if(root.val==target)
            return true;
          // System.out.println(root.val + " " + sb.toString());
        
        if(root.left!=null){
            sb.insert(0, "l");
            if(helper(root.left, sb, target))
                return true;
            sb.deleteCharAt(0);
        }
        
        if(root.right!=null){
            sb.insert(0, "r");
            if(helper(root.right, sb, target))
                return true;
            sb.deleteCharAt(0);
        }        
        
        return false;
        
    }
}
