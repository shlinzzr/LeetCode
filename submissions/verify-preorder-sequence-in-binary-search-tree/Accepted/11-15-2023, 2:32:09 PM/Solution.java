// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree

class Solution {
    public boolean verifyPreorder(int[] preorder) {

        Stack<Integer> st = new Stack<>();
        int small = Integer.MIN_VALUE;

        for (int i=0; i<preorder.length; i++)
        {
            if (preorder[i]<small) 
                return false;
            
            while (!st.isEmpty() && preorder[i]>st.peek()){
                small= st.pop();
            }
            st.push(preorder[i]);              
        }
        return true;
        
        /*. recursive
        int len = preorder.length;

        if(len<2) return true;

        int root = preorder[0];


        int i=1;
        while(i<len && preorder[i]<root){
            i++;
        }

        for(int j=i; j<len; j++){
            if(preorder[j]<root)
                return false;
        }

        boolean left = (i-1<1) ? true : verifyPreorder(Arrays.copyOfRange(preorder, 1, i));  // [1, i)
        boolean right = i+1>len ? true :  verifyPreorder(Arrays.copyOfRange(preorder, i, len)); // [i, len-1)

        return left && right;
        */


    }

}