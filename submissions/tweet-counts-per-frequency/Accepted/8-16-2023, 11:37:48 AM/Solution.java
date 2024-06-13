// https://leetcode.com/problems/tweet-counts-per-frequency

class TweetCounts {
    private Map<String, TreeMap<Integer, Integer>> map;
    
    public TweetCounts() {
        map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        
        int min = time/60;
        int hour = min/60;
        int day = hour/24;
        
        map.putIfAbsent(tweetName, new TreeMap<>());
        TreeMap<Integer, Integer> tmap = map.get(tweetName);
        tmap.put(time, tmap.getOrDefault(time, 0)+1);
        
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        if (!map.containsKey(tweetName)) 
            return null;
        
        List<Integer> res = new LinkedList<>();
        
        int interval = 0;
        if (freq.equals("minute")) {
            interval = 60;
        } else if (freq.equals("hour")) {
            interval = 3600;
        } else {
            interval = 86400;
        }
        
        int size = ((endTime - startTime) / interval) +1;
        
        int[] buckets = new int[size];
        
        TreeMap<Integer, Integer> tweetMap = map.get(tweetName);
        
        for (Map.Entry<Integer, Integer> entry : tweetMap.subMap(startTime, endTime + 1).entrySet()) {
            
            int index = (entry.getKey() - startTime) / interval;
            buckets[index] += entry.getValue();
        }
        
        for (int num : buckets) res.add(num);
        
        return res;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */