// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] ast) {

        int len = ast.length;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<len; i++){
            int a = ast[i];

            if(st.isEmpty()){
                st.push(a);
                continue;
            }

            if(a>0){
                st.push(a);
                continue;
            }else{
                
                boolean destory = false;
                while(!st.isEmpty()){

                    int abs = Math.abs(a);

                    if(st.peek()>abs){
                        destory=true;
                        break;
                    }else if(st.peek()==abs){
                        st.pop();
                        destory=true;
                        break;
                    }else if(st.peek()>0 && st.peek()<abs){ 
                        st.pop();
                    }
                }

                if(destory==false){
                    st.push(a);
                }
            }
        }

        int[] res = new int[st.size()];
        int idx =0 ;
        for(int a : st){
            res[idx++] = a;
        }

        return res;

        
    }
}