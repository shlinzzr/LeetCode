// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] A) {
        
        int len = A.length;
        
        Stack<Integer> st = new Stack<>();
        
        List<Integer> list = new ArrayList<>();
        
        
        for(int i=0; i<len; i++){
            
            int ast = A[i];
            
            if(ast>0){
                st.push(ast);
            
            }else{ // ast<0
                
                if(st.isEmpty()){
                    list.add(ast);
                    continue;
                }else{
                    
                    while(st.peek()<-ast){
                        st.pop();
                    }
                    
                    if(st.peek()==-ast){
                        st.pop();
                    }
                }  
            }
        }
        
        for(int ast : st){
            list.add(ast);
        }
        
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        return res;
        
        
        
    }
}