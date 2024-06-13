// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] ast) {

        int len = ast.length;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<len; i++){

            int cur = ast[i];

            if(st.isEmpty()){
                st.push(cur);   
            }else{

                if(cur>0){
                    st.push(cur);
                }else{

                    // if(cur<0 && !st.isEmpty() && st.peek()<0){
                    //     st.push(cur);
                    //     // System.out.println(st);
                    //     continue;
                    // }

                    

                    boolean add = true;
                    while(!st.isEmpty()){

                        if(cur<0 && st.peek()<0) 
                            break;

                        if(st.peek()<Math.abs(cur)){
                            st.pop();   
                        }
                        if(!st.isEmpty() && st.peek()==Math.abs(cur)){
                            add=false;
                            st.pop();
                            break;
                        }

                        if(!st.isEmpty() && st.peek()>Math.abs(cur)){
                            add=false;
                            break;
                        }
                    }

                    if(add) st.push(cur);
                }
            }
        }        

        int[] res = new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            res[i] = st.pop();
        }

        return res;
    }
}