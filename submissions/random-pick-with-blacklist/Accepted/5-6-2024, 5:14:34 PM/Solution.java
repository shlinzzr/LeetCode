// https://leetcode.com/problems/random-pick-with-blacklist

class Solution {

    Map<Integer, Integer> map ;
    Random r;
    int n;
    int len;
    public Solution(int n, int[] blacklist) {

        r = new Random();
        this.n = n;
        
        map = new HashMap<>();
        for(int b : blacklist){
            map.put(b, -1);
        }
        len = n - map.size();

        for(int b : blacklist){
            if(b<len){
                while(map.containsKey(n-1)){
                    n--;
                }

                map.put(b, n-1);
                n--;
            }

        }



        


        
    }
    
    public int pick() {
        int p = r.nextInt(len);
        if(map.containsKey(p))
            return map.get(p);

        return p;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */