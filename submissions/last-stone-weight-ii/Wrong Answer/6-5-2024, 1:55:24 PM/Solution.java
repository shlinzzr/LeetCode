// https://leetcode.com/problems/last-stone-weight-ii

class Solution {
    public int lastStoneWeightII(int[] stones) {

        int len = stones.length;

        // x <= y 


        int cnt = len ;
        Arrays.sort(stones);
        List<Integer> list = new ArrayList<>();
        for(int s : stones) list.add(s);

        while(list.size()>1){

            List<Integer> next = new ArrayList<>();
            for(int i=list.size()-1; i-1>=0; i-=2){
                int a = list.get(i);
                int b = list.get(i-1);
                if(a==b){
                    cnt-=2;
                    continue;
                }
                else{
                    int abs = Math.abs(a-b);
                    cnt--;
                    next.add(abs);
                }
            }
            list = next;
            Collections.sort(list);
        }

        return list.isEmpty() ? 0 : list.get(0);
        // 21 26 31 33 40
        // 5 2 40
        // 3 40


        // Stack<Integer> st = new Stack<>();
        // for(int i=0; i<len; i++){
        //     if(st.isEmpty()){
        //         st.push(stones[i]);
        //         continue;
        //     }else{
        //         boolean push = true;
        //         int cur = stones[i];
        //         while(!st.isEmpty()){

        //             if(st.peek()==cur){
        //                 push=false;
        //                 break;
        //             }

        //             cur = Math.abs(st.pop()-cur);
        //             if(st.isEmpty()){
        //                 st.push(cur);
        //             }
        //         }
        //     }
        // }

        // 8 7 4 2 1 1 

        // return st.peek();
        
    }
}