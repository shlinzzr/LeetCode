// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<len; i++){
            
            int a = asteroids[i];
            
            if(a>0){
                st.push(a);
                
            }else{ // a<0
                
                if(st.isEmpty()){
                    st.push(a);                    
                    
                }else{ // stack not empty
                    
                    boolean eq = false;
                    while(!st.empty() && st.peek()>0 && st.peek()+a<0){
                        st.pop();
                    }
                    
                    if(!st.isEmpty() && st.peek()+a==0){
                        eq=true;
                        st.pop();
                    }
                    
                    
                    if(eq)
                        continue;
                    
                    if(!st.isEmpty() && st.peek()<0){
                        st.push(a);
                    }
                }
            }
        }
        
        int[] res = new int[st.size()];
        int i=0;
        for(int a : st){
            res[i++]=a;
        }


        return res;
    }
    
    
}