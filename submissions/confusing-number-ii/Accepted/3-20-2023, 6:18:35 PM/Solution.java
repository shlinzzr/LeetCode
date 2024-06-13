// https://leetcode.com/problems/confusing-number-ii

class Solution {
    int[] base = {0,1,6,8,9};
    int[] reverse_board = {0,1,-1,-1,-1,-1,9,-1,8,6};
    public int confusingNumberII(int n) {
        
        // cal digit length
        int temp = n;
        int len = 0;
        while(temp>0){
            temp/=10;
            len++;
        }
        
        int ans = 0;
        if(len==10){
            n-=1;
            ans = 1;
            len-=1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int ori = 0;
        for(int i =0; i<len;i++){    // cal the digit lenght;
            int size = queue.size();
            while(size>0){
                int base_i = queue.poll();
                for(int j =0; j < base.length; j++){
                    int cur = base[j];
                    if(i==0&&cur==0)
                        continue;  // because only cnt [1, N];
                    
                    //build
                    ori=base_i*10+cur;
                    if(ori<=n){
                        //store 
                        queue.offer(ori);
                        
                        //check reverse
                        int rev = reverse(ori);
                        if(rev!=ori)ans++;                            
                    }
                }
                size--;
            }
        }
        return ans;
    }
    public int reverse(int b){
        int a = 0;
        while(b>0){
            int bit = b%10;
            b/=10;
            a = a*10+ reverse_board[bit];
        }
        return a;
    }
}
