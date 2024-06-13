// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        
        int len = preorder.length;
        
        if(len==0 || len==1)
            return true;
        
        int root = preorder[0];
        
        int i=1;
        for(; i<len ; i++){
            int p = preorder[i];
            if(p>root){
                break;
            }
        }
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