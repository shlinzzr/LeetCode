// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree

class Solution {
    public boolean verifyPreorder(int[] preorder) {

        int len = preorder.length;

        if(len==1) return true;

        int root = preorder[0];
        int i= 1;
        for(; i<len; i++){
            if(preorder[i]>root){
                break;
            }
        }

        return verifyPreorder(Arrays.copyOfRange(preorder, 1, i-1)) && verifyPreorder(Arrays.copyOfRange(preorder, i, len-1));
        
    }
}