// https://leetcode.com/problems/logger-rate-limiter

class Logger {

    
    HashMap<String, TreeSet<Integer>> map;
    
    public Logger() {
        
        map = new HashMap<>();
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(!map.containsKey(message)){
            map.put(message, new TreeSet<>());
            map.get(message).add(timestamp);
            return true;
        }else{
            
            if(map.get(message).higher(timestamp-10)==null){
                map.get(message).add(timestamp);
                return true;
            }else{
                return false;
            }
            
        }
        
        
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */