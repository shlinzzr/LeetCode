// https://leetcode.com/problems/stock-price-fluctuation

class StockPrice {

    HashMap<Integer, Integer> map;
    int currentPrice;
    int latestTime;
    TreeSet<Integer> set;
    
    public StockPrice() {
        map = new HashMap<>();
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
        }
        
    }
    
    public int current() {
        return currentPrice;
    }
    
    public int maximum() {
        return set.last();
    }
    
    public int minimum() {
        return set.first();
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