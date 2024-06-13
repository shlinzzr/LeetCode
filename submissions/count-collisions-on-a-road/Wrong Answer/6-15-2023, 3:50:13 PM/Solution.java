// https://leetcode.com/problems/count-collisions-on-a-road

class Solution {
    public int countCollisions(String dirs) {
        
        Stack<Integer> st = new Stack<>();
        
        
        
        
        int len = dirs.length();
        
        dirs= dirs +'S';
        
        int cnt=0;
        for(int i=0; i<len; i++){
            
            char ch = dirs.charAt(i);
            
            if(ch=='R')
                st.push(i);
            
            else if(ch=='S'){
                
                if(st.isEmpty()){
                    st.push(i);
                    
                }else{
                    if(dirs.charAt(st.peek())=='R'){
                        cnt++;
                        // st.pop();
                    }
                }
                st.push(i);
                
            }else if(ch=='L'){
                
                if(st.isEmpty()){
                    continue;
                    
                }else{
                    
                    if(dirs.charAt(st.peek())=='R'){
                        cnt+=2;
                        st.pop();
                        st.push(len);
                        
                    }else if(dirs.charAt(st.peek())=='S'){
                        cnt+=1;
                    }
                    
                    
                }
            }
        }
        
        return cnt;
        
        
    }
}