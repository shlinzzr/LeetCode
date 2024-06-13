// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int len = preorder.length;

        if(len<2) return true;
        
        int root = preorder[0];


        int i=1;
        while(preorder[i]<root){
            i++;
        }

        for(int j=i; j<len; j++){
            if(preorder[j]<root)
                return false;
        }

        boolean left = verifyPreorder(Arrays.copyOfRange(preorder, 1, i));
        boolean right = verifyPreorder(Arrays.copyOfRange(preorder, i+1, len));

        return left && right;


    }

}