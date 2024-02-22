// https://leetcode.com/problems/beautiful-towers-i

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        
        int len = maxHeights.size();
        
        long res =0;
        for(int i=0; i<len; i++){
            long sum = maxHeights.get(i);
            
            int max= maxHeights.get(i);
            for(int st=i-1; st>=0; st--){
                int val = Math.min(max, maxHeights.get(st));
                sum += val;
                max = Math.min(max, val);
            }
            
            max= maxHeights.get(i);
            for(int ed=i+1; ed<len; ed++){
                int val = Math.min(max, maxHeights.get(ed));
                sum += val;
                max = Math.min(max, val);
            }
            
            res = Math.max(sum , res);
       
        }
        
        return res;
        
//         int[] down = new int[len];
//         down[0]=maxHeights.get(0);
//         for(int i=1; i<len; i++){
//             down[i]=Math.min(down[i-1], maxHeights.get(i));
//         }
        
//         //[3,2,5,5,2,3]
//         // 3 2 2 2 2 2
        
//         //  5 3 3 1 1 
        
        
//         int[] up = new int[len];
//         up[len-1]=maxHeights.get(len-1);
//         for(int i=len-2; i>=0; i--){
//             up[i]=Math.min(up[i+1], maxHeights.get(i));
//         }
//         // 1 1 1 1 1
//         // 2 2 2 2 2 3 
        
        
     
        
        
//         int[] nextSmaller = new int[len];
//         Arrays.fill(nextSmaller, -1);
        
//         Stack<Integer> st = new Stack<>();
//         for(int i=0; i<len; i++){
            
//             int cur = maxHeights.get(i);
//             while(!st.isEmpty() && maxHeights.get(st.peek())>= cur){
//                 nextSmaller[st.pop()]=cur;
//             }
//             st.push(i);
//         }
        
//         for(int n : nextSmaller)
//         {   System.out.print(n + ",");
//             }
        
        
//         int[] prevSmaller = new int[len];
//          Arrays.fill(prevSmaller, -1);
//         st = new Stack<>();
//         for(int i=len-1; i>=0; i--){
            
//             int cur = maxHeights.get(i);
//             while(!st.isEmpty() && maxHeights.get(st.peek())>= cur){
//                 prevSmaller[st.pop()]=cur;
//             }
//             st.push(i);
//         }
        
//         long res = 0;
        
//         for(int i=0; i<len; i++){
            
//              res += Math.max(nextSmaller[i], prevSmaller[i]);
            
//         }
        
//         return res;
        
    }
    
    // 
}