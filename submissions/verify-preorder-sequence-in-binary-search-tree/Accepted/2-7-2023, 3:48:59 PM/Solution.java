// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        
        int len = preorder.length;
        
        System.out.println("len="+len);
        Stack<Integer> st = new Stack<>();
        
        if(len==0 || len==1)
            return true;
        
        int root = preorder[0];
        System.out.println("root="+root);
        
        int i=1;
        for(; i<len ; i++){
            int p = preorder[i];
            if(p>root){
                break;
            }
        }
         System.out.println("i="+i);
        for(int j=i; j<len; j++){
            int p = preorder[j];
            if(p<root)
                return false;
            }
           
            boolean left = (1>i-1)? true : verifyPreorder(Arrays.copyOfRange(preorder, 1, i));
            boolean right = (i>len)? true : verifyPreorder(Arrays.copyOfRange(preorder, i, len));


            return left && right;
        
    }
}