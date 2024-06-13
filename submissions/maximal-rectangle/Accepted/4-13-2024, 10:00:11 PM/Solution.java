// https://leetcode.com/problems/maximal-rectangle

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;

        int max =0;
        int[] arr = new int[w];
        for(int i=0; i<h; i++){
            
            for(int j=0; j<w; j++){
                if(matrix[i][j]=='1'){
                    arr[j]++;
                }else
                    arr[j]=0;
            }

            max = Math.max(max, largestRectangleArea(arr));
        }
        return max;
    }


    // 84. Largest Rectangle in Histogram

     public int largestRectangleArea(int[] arr) {

        int len = arr.length;
        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, len);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){

            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        int[] prevSmaller = new int[len];
        Arrays.fill(prevSmaller, -1);
        for(int i=len-1; i>=0; i--){

            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }


        int max = 0;
        for(int i=0; i<len; i++){
            max = Math.max(max, (nextSmaller[i] - prevSmaller[i]-1)*arr[i]);
        }
        return max;
    }
}