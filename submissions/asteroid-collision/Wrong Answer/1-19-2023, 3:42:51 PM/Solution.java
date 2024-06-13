// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int len = asteroids.length;
        
        
        
        for(int i=0; i<len;i++){
            
            int ast = asteroids[i];
            
            if(st.isEmpty()){
                st.push(ast);
                
            }else{
                if(ast<0){
                    while(!st.isEmpty()){
                        if(st.peek()<0){
                            st.push(ast);
                            break;
                        }else{
                            
                            if(Math.abs(ast)==Math.abs(st.peek())){
                                st.pop();
                                break;
                            }else if(Math.abs(ast)<Math.abs(st.peek())){
                                break;
                            }else{
                                st.pop();
                            }
                        }    
                    }
                }else{
                    st.push(ast);
                }
            }
        }
        
        int[] res = new int[st.size()];
        int siz = st.size();
        for(int i=siz;i>0; i--){
            res[i-1]=st.pop();
        }
        
        return res;
    }
}