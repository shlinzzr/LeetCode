// https://leetcode.com/problems/find-the-first-player-to-win-k-games-in-a-row

class Solution {
    
    class Gamer{
        int idx;
        int lv;
        int cnt=0;
        
        public Gamer(int idx, int lv){
            this.idx = idx;
            this.lv = lv;
        }
            
    }
    public int findWinningPlayer(int[] skills, int k) {
        // 1. 後面有兩個smaller
        // 2. 前面沒有比較大的, 前面跟後面都至少有一個比較小的
        //prev Greater == -1 and nextGreater-i>k-1
        int len = skills.length;
        
        
        
        // [4,2,6,3,9], k = 2
        
        
        int max= 0;
        for(int i=0; i<len-k; i++){
            for(int j=i+1; j<len; j++){
                if(skills[j]>skills[i]){
                    i=j-1;
                    break;
                }
                
                if(i==0) {
                    if(j-i+1>=k+1) { return i;}
                }
                    
                else {
                    if(j-i+1>=k) return i;
                }
                    
            }
            
        }
        int res= 0 ;
        for(int i=0; i<len; i++){
            if(skills[i]>max){
                res = i;
                max = skills[i];
            }
        }
        
        return res;
        
        // [x x x x  last |x xx x] 
        //  ^            
        
//         Stack<Integer> st= new Stack<>();
//         int[] nextGreater = new int[len];
//         for(int i =0; i<len; i++){
//             while(!st.isEmpty() && skills[st.peek()]<skills[i] ){
//                 nextGreater[st.pop()] = i;
//             }
//             st.push(i);            
//         }
        
        
//         int[] prevGreater = new int[len];
//         Arrays.fill(prevGreater, -1);
//         for(int i=len-1; i>=0; i--){
//             while(!st.isEmpty() && skills[i]>skills[st.peek()]){
//                 prevGreater[st.pop()] = i;
//             }
//             st.push(i);
//         }
        
        
//         //0 1 2 3
//         //^   ^  
//         for(int i=0; i<len; i++){
//             if(i==0)
//                 if(prevGreater[i]==-1 && nextGreater[i]-i>=k+1) return i;
//             else
//                 if(prevGreater[i]==-1 && nextGreater[i]-i>=k) return i;
//         }
        
        
    }
}