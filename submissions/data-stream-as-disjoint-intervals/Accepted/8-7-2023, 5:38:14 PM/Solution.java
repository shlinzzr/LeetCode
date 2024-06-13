// https://leetcode.com/problems/data-stream-as-disjoint-intervals

class SummaryRanges {

    private Set<Integer> set;

    public SummaryRanges() {
        set = new TreeSet<>();
    }
    
    public void addNum(int value) {
       set.add(value);
    }
    
    public int[][] getIntervals() {
        
        if (set.isEmpty()) {
            return new int[0][];
        }
        
        List<int[]> intervals = new ArrayList<>();
        int left = -1, right = -1;
        for (Integer val : set) {
            if (left < 0) {
                left = val;
                right= val;
                
            } else if (val == right + 1) {
                right = val;
                
            } else {
                intervals.add(new int[] {left, right});
                left = val;
                right= val;
            } 
        }
        intervals.add(new int[] {left, right});
        return intervals.toArray(new int[0][]); 
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */