// https://leetcode.com/problems/maximum-frequency-stack

class FreqStack {
    
    HashMap<Integer, Integer> freq; // <num, freq>;
    HashMap<Integer, List<Integer>> cntMap; // <cnt, List<num>>
    int max;
    
    public FreqStack() {
        freq = new HashMap<>();
        cntMap = new HashMap<>();
        max=0;
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0)+1);
        int f = freq.get(val);
        
        List<Integer> list = cntMap.getOrDefault(f, new ArrayList<Integer>());
        list.add(val);
        cntMap.put(f, list);
        max = Math.max(f, max);
            
    }
    
    public int pop() {
        List<Integer> list = cntMap.get(max);
        
        int res = list.get(list.size()-1);
        list.remove(list.size()-1);
        if(list.size()==0)
            max-=1;
        
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */