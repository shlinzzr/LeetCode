// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree

class Solution {

    // class Node{
    //     Node left;
    //     Node right;
    //     int val;
    //     public Node(val){
    //         this.val=val;
    //     }
    // }


    public boolean isValidSerialization(String preorder) {

        String[] arr = preorder.split(",");
        int len = arr.length;

        int deg =1;

        for(int i=0; i<len ;i++){
            String s = arr[i];

            if(--deg<0) // 不管是什node. outdegree都會+1, 所以total --deg, 檢查若不足0必為illgle
                return false;

            if(!"#".equals(s)){ // 只要不是#, outDeg就+2 
                deg+=2;
            }
        }

        return deg ==0;

        
    }

    // private boolean helper(char[] arr, int idx){

    //     int val = arr[idx];
    //     Node node = new Node(val);




    // }
}