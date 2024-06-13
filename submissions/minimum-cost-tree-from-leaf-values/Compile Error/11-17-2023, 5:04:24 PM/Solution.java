// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values

class Solution {
    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        if(len==1)
            return 0;

        int[] nextGreater = new int[len];
        Arrays.fill(nextGreater, len);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){

            if(st.isEmpty() || arr[i] <= arr[st.peek()]){
                st.push(i);
                continue;
            }
            

            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                nextGreater[st.pop()] = i;
            }
            st.push(i);
        }

        int[] prevGreater = new int[len];
        Arrays.fill(prevGreater, -1);
        st.clear();
        for(int i=len-1; i>=0; i--){

            if(st.isEmpty() || arr[i] <= arr[st.peek()]){
                if(!st.isEmpty()){
                    prevGreater[i] == arr[stack.pop()];
                }


                st.push(i);
                continue;
            }
            
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                prevGreater[st.pop()] = i;
            }
            st.push(i);
        }


        int res = 1;
        for(int i=0; i<len; i++){
            
            if(nextGreater[i]!=len && prevGreater[i]!=-1){
                res *= Math.min(arr[nextGreater[i]],  arr[prevGreater[i]]);

            }else if(nextGreater[i]!=len){
                res *= arr[nextGreater[i]];

            }else if(prevGreater[i]!=-1)
                res *=arr[prevGreater[i]];
        }

        return res;


    }
}

/*
sol stack

[ x x1 x2 x x ] [x x x x x]

x1 : [..a]
x2 : [..b]

cost = Math.max(a, b) 小的數字被刪除
其實就是找cost = Math.min(prevGreater, nextGreater);
相消之後不影響後續抉擇



sol dp:

[x x x x x] [x x x x j]
 i.      k

 dp[i][j] = min { max[i][k]*max[k+1][j] + dp[i][k] + dp[k+1][j] } over k : i~j

*/



/* 

a b c

abc + ab is smaller

    c* Math.max(a,b)
    / \
  ab   c 
  /\    
 a  b 


 a * Math.max(b,c)
 /.  \
 a   bc
    / \
   b   c



*/