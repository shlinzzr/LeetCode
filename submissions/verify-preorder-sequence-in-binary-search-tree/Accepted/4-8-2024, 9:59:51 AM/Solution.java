// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree

class Solution {
    public boolean verifyPreorder(int[] preorder) {

        int len = preorder.length;

        if(len==1 || len==0) return true;

        int root = preorder[0];
        int i= 1;
        for(; i<len; i++){
            if(preorder[i]>root){
                break;
            }
        }

        for(int j=i; j<len; j++){
            if(preorder[j]<root)
                return false;
        }


        boolean left = (i-1<1) ? true :  verifyPreorder(Arrays.copyOfRange(preorder, 1, i)) ;
        boolean right = i+1>len ? true : verifyPreorder(Arrays.copyOfRange(preorder, i, len));
        return left && right;

        
    }
}

//      int len = preorder.length;

//         if(len<2) return true;

//         int root = preorder[0];


//         int i=1;
//         while(i<len && preorder[i]<root){
//             i++;
//         }

//         for(int j=i; j<len; j++){
//             if(preorder[j]<root)
//                 return false;
//         }

//         boolean left = (i-1<1) ? true : verifyPreorder(Arrays.copyOfRange(preorder, 1, i));  // [1, i)
//         boolean right = i+1>len ? true :  verifyPreorder(Arrays.copyOfRange(preorder, i, len)); // [i, len-1)

//         return left && right;
// }