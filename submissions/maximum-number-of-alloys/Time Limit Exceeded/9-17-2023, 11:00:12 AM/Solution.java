// https://leetcode.com/problems/maximum-number-of-alloys

class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        
        int alloys=0;
        
        for(int i=0; i<k; i++){
            
            int cnt =0;
            List<Integer> com = composition.get(i);
            List<Integer> sto = new ArrayList<>(stock);
            
            int consume = getConsume(com, sto, cost);
            
            int b = budget;
            
            while(b-consume>=0){
                cnt++;
                b-=consume;
                consume = getConsume(com, sto, cost);
            }
            
            alloys = Math.max(alloys, cnt);
            
            
        }
        
        return alloys;
        
    }
    
    private int getConsume(List<Integer> com ,List<Integer> sto,List<Integer> cost  ){
        
          int consume = 0;
            for(int j=0; j<com.size(); j++){
               
                if(sto.get(j)>=com.get(j)){
                    sto.set(j, sto.get(j)-com.get(j));
                }else if(sto.get(j)==0){
                    consume += com.get(j)*cost.get(j);
                }else if(sto.get(j)<com.get(j)){
                   
                    consume += (com.get(j)-sto.get(j))*cost.get(j);
                    sto.set(j, 0);
                }
            }
        
        return consume;
        
    }
}