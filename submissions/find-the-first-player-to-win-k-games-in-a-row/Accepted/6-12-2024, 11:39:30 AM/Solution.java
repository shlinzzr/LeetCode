// https://leetcode.com/problems/find-the-first-player-to-win-k-games-in-a-row

class Solution {
    public int findWinningPlayer(int[] skills, int k) {

        int n = skills.length;

        int max_i = 0;
        int win = -1;
        for(int i=0; i< skills.length; i++){
            int x = skills[i];
            if(x>skills[max_i]){
                max_i = i;
                win = 0;
            }
            win++;

            if(win==k) break;
        }

        return max_i;



        // int[] copy = new int[2*n];

        // System.arraycopy(skills, 0, copy, 0, n);
        // System.arraycopy(skills, 0, copy, n, n);

        // int[] nextGreater = new int[n*2];
        // Arrays.fill(nextGreater, 2*n);

        // Stack<Integer> st = new Stack<>();

        // for(int i=0; i<n; i++){
        //     while(!st.isEmpty() && copy[st.peek()] < copy[i]){
        //         int idx = st.pop();
        //         nextGreater[idx] = i;
        //         int middle = i-idx-1;
        //         if(middle>=k) return idx;
        //     }
        // }

        // return -1;

        // [ idx x x x i]
        //    0  1 2 3 4      



        // List<int[]> list= new ArrayList<>();
        // for(int i=0; i<n; i++){
        //     list.add( new int[]{skills[i], i});
        // }

        // int cnt = 0;

        // while(cnt<k){
        //     int[] a = list.get(0);
        //     int[] b = list.get(1);

        //     if(a[0]>b[0]){ 
        //         cnt++ ;
        //     }else{
        //         cnt = 1;
        //     }

        //     if(cnt==k) return a[1];
        // }

        // return -1;

        
    }
}