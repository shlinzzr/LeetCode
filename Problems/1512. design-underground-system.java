// https://leetcode.com/problems/design-underground-system

class UndergroundSystem {

    HashMap<Integer, Integer> timeMap;
    HashMap<Integer, String> sMap;
    
    HashMap<String, int[]> map; 
    
    
    public UndergroundSystem() {
        timeMap = new HashMap<>();
        sMap = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        timeMap.put(id, t);
        sMap.put(id, stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        String fromStat = sMap.get(id);
        int cinTime = timeMap.get(id);
        
        String key = fromStat + "-" + stationName;
        int costTime = t- cinTime;
        int[] val = map.getOrDefault(key, new int[]{0,0});
        
        val[0] += costTime;
        val[1] += 1;
        
        map.put(key , val);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        int[] val = map.get(startStation + "-" + endStation);
        
        return Double.valueOf(val[0])/val[1];
        
        
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */