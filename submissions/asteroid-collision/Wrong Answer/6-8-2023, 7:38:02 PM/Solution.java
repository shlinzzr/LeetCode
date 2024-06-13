// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] A) {
        
        int len = A.length;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<len; i++){
            
            int ast = A[i];
            
            if(ast>0){
                st.push(ast);
            }else{ // ast<0
                
                if(st.isEmpty()){
                    st.add(ast);
                    continue;
                    
                }else{
                    if(st.peek()<0){
                        st.push(ast);
                        continue;
                        
                    }else{
                        
                        if(Math.abs(st.peek()) > Math.abs(ast))
                           continue;
                       
                        
                        boolean eq = false;
                        while(!st.isEmpty() && st.peek()<=Math.abs(ast)){
                            
                            if(Math.abs(st.peek())==Math.abs(ast)){
                                eq=true;
                                st.pop();
                                break;
                            }
                            
                            st.pop();
                        }
                        
                        if(eq)
                            continue;
                            
                        if(st.isEmpty() || st.peek()<0)
                            st.push(ast);
                    }
                    
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