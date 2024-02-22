// https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        
       
        Set<String> foodSet = new TreeSet<>();
        List<String> tableList = new ArrayList<>();
        
        TreeMap<String, TreeMap<String, Integer>> tableMap = new TreeMap<>();
        
        
        for(List<String> list : orders){
            
            String customerName = list.get(0);
            String tableNumber = list.get(1);
            String foodItem = list.get(2);
            
            foodSet.add(foodItem);
            
            if(!tableList.contains(tableNumber))
                tableList.add(tableNumber);
            
            if(!tableMap.containsKey(tableNumber)){
                tableMap.put(tableNumber, new TreeMap<>());
            }
            
            TreeMap<String, Integer> foodMap = tableMap.get(tableNumber);
            if(!foodMap.containsKey(foodItem))
                foodMap.put(foodItem, 0);
            
            foodMap.put(foodItem, foodMap.getOrDefault(foodItem, 0)+1);
        }
        
        List<List<String>> res = new ArrayList<>();
        
        List<String> foodList = new ArrayList<>();
        foodList.add("Table");
        for(String f: foodSet){
            foodList.add(f);
        }
        res.add(foodList);
        
        
        Collections.sort(tableList, (t1,t2) -> Integer.compare(Integer.valueOf(t1),Integer.valueOf(t2)));
        
        
        for(String tableNum : tableList){
            
            List<String> tableRow = new ArrayList<>();
            tableRow.add(tableNum);
            
            Map<String, Integer> foodMap = tableMap.get(tableNum);
            for(String f: foodSet){
                tableRow.add(String.valueOf(foodMap.get(f)==null?0 : foodMap.get(f)));
            }
            
            res.add(tableRow);
        }
        
        
        
        
        return res;
        
        
        
    }
}
