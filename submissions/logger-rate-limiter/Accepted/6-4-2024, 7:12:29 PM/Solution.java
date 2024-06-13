// https://leetcode.com/problems/logger-rate-limiter

class Logger {
    
    
    TreeMap<String, Integer> map;
    
    public Logger() {
        
        map = new TreeMap<>();
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int prev = map.get(message);
            if(prev>timestamp-10) return false;
        }
        map.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */