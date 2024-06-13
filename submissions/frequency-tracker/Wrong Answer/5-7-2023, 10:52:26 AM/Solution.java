// https://leetcode.com/problems/frequency-tracker

class FrequencyTracker {

    HashMap<Integer, Set<Integer>> freq;
    HashMap<Integer, Integer> map;
    
    public FrequencyTracker() {
        map = new HashMap<>();
          freq = new HashMap<>();
    }
    
    public void add(int number) {
        map.putIfAbsent(number, 0);
        map.put(number, map.getOrDefault(number, 0)+1);
        freq.putIfAbsent(map.get(number), new HashSet<>());
        freq.get(map.get(number)).add(number);
    }
    
    public void deleteOne(int number) {
        if(!map.containsKey(number))
            return;
        
        int f = map.get(number);
        freq.get(f).remove(number);
        if(freq.get(f).size()==0)
            freq.remove(f);
        
        if(map.get(number)==1){
            map.remove(number);
            return;
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