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

            if(--deg<0) 
                return false;

            if(!"#".equals(s)){ 
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