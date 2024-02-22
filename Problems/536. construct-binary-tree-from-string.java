// https://leetcode.com/problems/construct-binary-tree-from-string

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

    public TreeNode str2tree(String s) {

        int len = s.length();
        if(s==null || len==0)
            return null;

        // find root
        int first = s.indexOf("(");
        if(first==-1){
            return new TreeNode(Integer.valueOf(s));
        }
        TreeNode root = new TreeNode(Integer.valueOf(s.substring(0, first)));

        int start = first, level = 0;

        for (int i=start; i<s.length(); i++) {

            if (s.charAt(i) == '(') 
                level++;
            else if (s.charAt(i) == ')') 
                level--;

            if (level == 0 && start==first) {
                root.left = str2tree(s.substring(start+1,i)); 
                start = i+1;
            } else if (level == 0) {
                root.right = str2tree(s.substring(start+1,i));
            }
                
        }
        return root;


    }

/* 
  i->
"4(2(3)(1)) (6(5))"
  ^       ^
first.   lv=0 (start==first)
            ^
           start
   4
  /\

*/






    /*
    public TreeNode str2tree(String s) {
        int len = s.length();

        TreeNode parent=null, curr=null;

        Stack<TreeNode> st = new Stack<>();

        int sign=1, idx=0;
        while(idx<s.length()){
            
            char ch = s.charAt(idx);
            if(ch==')'){
                curr = st.pop();
                parent = st.peek();
                if(parent.left!=null){
                    parent.right=curr;
                }else{
                    parent.left=curr;
                }
                idx++;

            } else if(ch=='-'){
                sign=-1;
                idx++;

            } else if(ch=='('){
                idx++;

            } else{

                int num = ch-'0';
                while(idx+1<len && s.charAt(idx+1)>='0' && s.charAt(idx+1)<='9'){
                    num=num*10+s.charAt(idx+1)-'0';
                    idx++;
                }
                num *= sign;
                sign=1;
                st.push(new TreeNode(num));
                idx++;
            }
        }

        if (!st.isEmpty()) {
            return st.peek();
        }

        return parent;

    }*/


}