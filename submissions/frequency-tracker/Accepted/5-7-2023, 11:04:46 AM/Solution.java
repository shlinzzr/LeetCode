// https://leetcode.com/problems/frequency-tracker

class FrequencyTracker {

    HashMap<Integer, Set<Integer>> freq;
    HashMap<Integer, Integer> map;
    
    public FrequencyTracker() {
        map = new HashMap<>();
        freq = new HashMap<>();
    }
    
    public void add(int number) {
        
        Integer f = map.getOrDefault(number, 0);
        if( freq.containsKey(f)){
            freq.get(f).remove(number);
            if(freq.get(f).size()==0)
                freq.remove(f);
        }
            
        map.put(number, f+1);
        
        freq.putIfAbsent(f+1, new HashSet<>());
        freq.get(f+1).add(number);
    }
    
    public void deleteOne(int number) {
        if(!map.containsKey(number))
            return;
        
        int f = map.get(number);
        freq.get(f).remove(number);
        if(freq.get(f).size()==0)
            freq.remove(f);
        
        if(f==1){
            map.remove(number);
            return;
        }else{
            freq.putIfAbsent(f-1, new HashSet<>());
            freq.get(f-1).add(number);
        }
            
        map.put(number, map.get(number)-1);
    }
    
    public boolean hasFrequency(int frequency) {
        return freq.containsKey(frequency);
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */