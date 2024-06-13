// https://leetcode.com/problems/random-pick-with-blacklist

class Solution {

    Set<Integer> set;
    Random r;
    int n;
    public Solution(int n, int[] blacklist) {

        this.n = n;
        r = new Random();
        set = new HashSet<>();
        for(int b : blacklist){
            set.add(b);
        }
        
    }
    
    public int pick() {
        int p = r.nextInt(n);
        if(set.contains(p)){
            return pick();
        }

        return p;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */