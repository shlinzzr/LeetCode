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
                    
                
                    while(!st.empty() &&st.peek()< Math.abs(a)){
                        st.pop();
                    }
                    
                    
                    boolean eq = false;
                    if(!st.isEmpty() && st.peek()==Math.abs(a)){
                        eq=true;
                        st.pop();
                    }
                    
                    if(st.empty() && eq==false){
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