// https://leetcode.com/problems/shortest-distance-to-target-color

class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Stack<Integer> st = new Stack<>();
        
        int len = colors.length;
        
        
        int[] nextGreater = new int[len];
        Arrays.fill(nextGreater, Integer.MAX_VALUE);
        
        for(int i=0; i<colors.length; i++){
            while(!st.isEmpty() && colors[st.peek()]<colors[i]){
                nextGreater[st.pop()] = i;
            }
            st.push(i);
        }
        
        // for(int i=0; i<nextGreater.length; i++){
        //     System.out.print(nextGreater[i] + ",");
        // }
        // System.out.println();
        
        st.clear();
        int[] prevGreater = new int[len];
        Arrays.fill(prevGreater, Integer.MIN_VALUE);
        for(int i=len-1; i>=0 ; i--){
            while(!st.isEmpty() && colors[st.peek()] < colors[i]){
                prevGreater[st.pop()] = i;
            }
            st.push(i);
        }
        // for(int i=0; i<prevGreater.length; i++){
        //     System.out.print(prevGreater[i] + ",");
        // }
        // System.out.println();
        
        
        st.clear();
        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, Integer.MAX_VALUE);
        for(int i=0; i<colors.length; i++){
            while(!st.isEmpty() && colors[st.peek()]>colors[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }
        //  for(int i=0; i<nextSmaller.length; i++){
        //     System.out.print(nextSmaller[i] + ",");
        // }
        // System.out.println();
        
        st.clear();
        int[] prevSmaller = new int[len];
        Arrays.fill(prevSmaller, Integer.MIN_VALUE);
        for(int i=len-1; i>=0 ; i--){
            while(!st.isEmpty() && colors[st.peek()] > colors[i]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }
        
//          for(int i=0; i<prevSmaller.length; i++){
//             System.out.print(prevSmaller[i] + ",");
//         }
//         System.out.println();
        
        
        
        int[] res = new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            int[] q = queries[i];
            int idx = q[0];
            int targetColor = q[1];
            int currentColor = colors[idx];
            
            if(targetColor==currentColor){
                res[i] = 0;
            }else if(targetColor>currentColor){
                
                
                
                int next = (targetColor-currentColor==2) ? 
                    (nextGreater[idx]==Integer.MAX_VALUE? Integer.MAX_VALUE : nextGreater[nextGreater[idx]]) : nextGreater[idx];
                int prev = (targetColor-currentColor==2) ? 
                    (prevGreater[idx]==Integer.MIN_VALUE? Integer.MIN_VALUE : prevGreater[prevGreater[idx]]) : prevGreater[idx];
                
                if(i==0){
                    System.out.println(next + " " + prev); 
                }
                
                if(next==Integer.MAX_VALUE && prev==Integer.MIN_VALUE) 
                    res[i]=-1;
                else if(next!=Integer.MAX_VALUE && prev==Integer.MIN_VALUE)
                    res[i] = next-idx;
                    
                else if(next==Integer.MAX_VALUE && prev!=Integer.MIN_VALUE)
                    res[i] = idx-prev;
                else 
                    res[i] = Math.min(next-idx, idx-prev);
                
            }else{
                int next = (currentColor-targetColor==2) ? 
                    (nextSmaller[idx]==Integer.MAX_VALUE ? Integer.MAX_VALUE : nextSmaller[nextSmaller[idx]]) : nextSmaller[idx];
                int prev = (currentColor-targetColor==2) ? 
                    (prevSmaller[idx]==Integer.MIN_VALUE ? Integer.MIN_VALUE : prevSmaller[prevSmaller[idx]]) : prevSmaller[idx];
                    
                if(next==Integer.MAX_VALUE && prev==Integer.MIN_VALUE) 
                    res[i]=-1;
                else if(next!=Integer.MAX_VALUE && prev==Integer.MIN_VALUE)
                    res[i] = next-idx;
                    
                else if(next==Integer.MAX_VALUE && prev!=Integer.MIN_VALUE)
                    res[i] = idx-prev;
                else 
                    res[i] = Math.min(next-idx, idx-prev);
                
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<res.length; i++){
            list.add(res[i]);
        }
        
        return list;
        
        
        
    }
}