// https://leetcode.com/problems/maximum-frequency-stack

class FreqStack {
    
    TreeMap<Integer, List<Integer>> fmap = new TreeMap<>(); // freq, list of val
    Map<Integer, Integer> vmap = new HashMap<>(); //val, freq
    public FreqStack() {
        fmap = new TreeMap<>();
        vmap = new HashMap<>();
    }
    
    public void push(int val) {
        
        if(!vmap.containsKey(val)){
            List<Integer> list = fmap.getOrDefault(1 , new ArrayList<>());
            list.add(val);
            fmap.put(1, list);

            vmap.put(val, 1);
            return;
        }

        int freq = vmap.get(val)+1;
        List<Integer> list = fmap.getOrDefault(freq, new ArrayList<>());
        list.add(val);
        fmap.put(freq, list);
        vmap.put(val, freq);
    }

      
    // public void push(int val) {
        
    //     int freq = vmap.getOrDefault(val, 0)+1;
    //     vmap.put(val, freq);
        
    //     fmap.putIfAbsent(freq, new ArrayList<>());
    //     fmap.get(freq).add(val);
    // }

     public int pop() {

        int last = fmap.lastKey();
        List<Integer> list = fmap.get(last);
        int res = list.get(list.size()-1);
        list.remove(list.size()-1);
        
        if(list.size()==0)
            fmap.remove(last);
        
        vmap.put(res, vmap.get(res)-1);
        return res;
        
        
    }

    // public int pop() {
    //     int f = fmap.lastKey();

    //     List<Integer> list = fmap.get(f);
    //     int val = list.remove(list.size()-1);

    //     if(list.size()==0)
    //         fmap.remove(f);

    //     vmap.remove(val);

    //     if(f-1>0) 
    //         vmap.put(val, f-1);

    //     return val;
    // }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */