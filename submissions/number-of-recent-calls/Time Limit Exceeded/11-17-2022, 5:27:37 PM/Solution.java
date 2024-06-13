// https://leetcode.com/problems/number-of-recent-calls

class RecentCounter {

    List<Integer> list;
    
    public RecentCounter() {
        list = new ArrayList<>();
        
    }
    
    public int ping(int t) {
        list.add(t);
        
        int cnt=0;
        for(int i : list){
            if(i>=t-3000 && i<=t){
                cnt++;
            }
        }
        
        return cnt;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */