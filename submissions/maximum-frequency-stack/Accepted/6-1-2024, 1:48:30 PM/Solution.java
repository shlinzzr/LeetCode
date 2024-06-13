// https://leetcode.com/problems/maximum-frequency-stack

class FreqStack {

    Map<Integer, Integer> map ; // val, freq
    Map<Integer, LinkedHashSet<Integer>> fmap; // freq, val
    int maxFreq = 0;


    public FreqStack() {
        map = new HashMap<>();
        fmap = new HashMap<>();
        fmap.put(1, new LinkedHashSet<>());
        fmap.put(0, new LinkedHashSet<>());
        
    }
    
    public void push(int val) {

        if(!map.containsKey(val)){
            map.put(val, 1);
            fmap.putIfAbsent(1, new LinkedHashSet<>() );
            fmap.get(1).add(val);
            maxFreq = Math.max(maxFreq, 1);
            return;
        }else{
            int f = map.get(val);
            map.put(val, f+1);
            // fmap.get(f).remove(val);
            fmap.putIfAbsent(f+1, new LinkedHashSet<>());
            fmap.get(f+1).add(val);


            maxFreq = Math.max(f+1, maxFreq);

        }
        
    }
    
    public int pop() {

        List<Integer> list = new ArrayList<>(fmap.get(maxFreq));
        int key = list.get(list.size()-1);
        
        int f = map.get(key);
        if(f>1) map.put(key, f-1);

        fmap.get(maxFreq).remove(key);
        if(fmap.get(maxFreq).size()==0){
            fmap.remove(maxFreq);
            maxFreq--;
        }

        return key;

        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */