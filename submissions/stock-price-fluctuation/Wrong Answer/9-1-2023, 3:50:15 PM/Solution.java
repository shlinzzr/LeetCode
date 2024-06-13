// https://leetcode.com/problems/stock-price-fluctuation

class StockPrice {

    HashMap<Integer, Integer> map;
    int currentPrice;
    int latestTime;
    int max;
    int min;
    TreeSet<Integer> set;
    
    public StockPrice() {
        map = new HashMap<>();
        // max = Integer.MIN_VALUE;
        // min = Integer.MAX_VALUE;
        latestTime = 0;
        currentPrice = 0;
        set = new TreeSet<>();
    }
    
    public void update(int timestamp, int price) {
        
        if(map.containsKey(timestamp)){
            int p = map.get(timestamp);
            set.remove(p);
        }
        
        set.add(price);
        map.put(timestamp, price);
        
        if(timestamp>=latestTime){
            latestTime = timestamp;
            currentPrice=price;
            // max= Math.max(max, price);
            // min = Math.min(min, price);
        }
        
    }
    
    public int current() {
        return currentPrice;
    }
    
    public int maximum() {
        return set.floor(Integer.MAX_VALUE);
    }
    
    public int minimum() {
        return set.ceiling(Integer.MIN_VALUE);
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */