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
        if(len==0 || "#".equals(preorder)){
            return true;
        } 

        int deg =1;

        for(int i=0; i<len ;i++){
            String s = arr[i];

            if("#".equals(s)){
                deg--;
            }else {
                deg++;
            }
            System.out.print(deg+ ",");
        }

        return deg==0;

    // 9,3,4,#,#,1,#,#,2,#,6,#,#
    // 2 3 4 3 2 3 2 1 2 1 2 1 0
        
    }

    // private boolean helper(char[] arr, int idx){

    //     int val = arr[idx];
    //     Node node = new Node(val);




    // }
}