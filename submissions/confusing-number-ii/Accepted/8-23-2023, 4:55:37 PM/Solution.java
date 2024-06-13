// https://leetcode.com/problems/confusing-number-ii

class Solution {
    int[] base = {0,1,6,8,9};
    int[] mapping = {0,1,-1,-1,-1,-1,9,-1,8,6};
    public int confusingNumberII(int n) {
        
        // cal digit length
        int temp = n;
        int len = 0;
        while(temp>0){
            temp/=10;
            len++;
        }
        
        long ans = 0;
        if(len==10){ // n==1e9 => ansOf(1e9)== 1 + ansOf(1e9-1)
            n-=1;
            ans = 1;
            len-=1;
        }
        
        
        // use bfs to grow digit by digit
        // [0] => {0, 1, 9, 8, 6} =>[0, 1, 9, 8, 6]=> [00,01,09,08,06,  10,11,19,18,16,  90,91,99,98,96...]
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int ori = 0;
        for(int i =0; i<len;i++){    // cal the digit lenght;
            int size = queue.size();
            while(size>0){
                int p = queue.poll();
                for(int b : base){
                    if(i==0 && b==0)
                        continue;  // because only cnt [1, N], 0 is excluded
                    
                    //build
                    ori = p*10 + b;
                    if(ori<=n){
                        queue.offer(ori);
                        
                        //check confusing
                        if(confusing(ori)!=ori)
                            ans++;                    
                    }
                }
                size--;
            }
        }
        return (int)ans;
    }
    public int confusing(int n){
        int conf = 0;
        while(n>0){
            int digit = n%10;
            n/=10;
            conf = conf*10+ mapping[digit];
        }
        return conf;
    }
}
