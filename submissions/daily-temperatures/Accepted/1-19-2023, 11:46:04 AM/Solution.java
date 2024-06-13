// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int len = temp.length;
        
        int[] res = new int[len];
        
        
        Stack<int[]> st = new Stack<>();
        
        for(int i=0; i<len; i++){
            
            if(st.isEmpty()){
                st.push(new int[]{temp[i], i});
            }else{
                
                while(!st.isEmpty() && st.peek()[0]<temp[i]){
                    
                    int[] p = st.pop();
                    res[p[1]] = i-p[1]; 
                }
                
                st.push(new int[]{temp[i], i});
            }
        }
        
        while(!st.isEmpty()){
            int[] p = st.pop();
            res[p[1]]=0;
        }
        
        
        return res;
    }
}