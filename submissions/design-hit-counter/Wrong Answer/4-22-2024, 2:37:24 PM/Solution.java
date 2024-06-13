// https://leetcode.com/problems/design-hit-counter

class HitCounter {


    TreeSet<Integer> set ;
    public HitCounter() {

        set = new TreeSet<>();

        
    }
    
    public void hit(int timestamp) {
        set.add(timestamp);
    }
    
    public int getHits(int timestamp) {

        Integer floor = set.floor(timestamp-300);
        while(floor!=null){
            set.remove(floor);
            floor = set.floor(timestamp-300);
        }

        return set.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */