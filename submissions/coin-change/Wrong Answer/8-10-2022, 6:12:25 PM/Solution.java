// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        
        List<Integer> list = new ArrayList<>();
        for(int c : coins){
            list.add(0, c);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        int cnt =0;
        
        while(amount >= coins[0]){
            
            for(int c : list){
                if(amount>=c){
                     cnt+=amount/c;
                   // System.out.println("c="+ c + " amount="+amount + " cnt="+cnt);
                    
                  
                   amount%=c;
                    
                // System.out.println("amount="+amount);
                    
                    System.out.println();
                    
                   
                   break;
                }
            }
        }
        
        if(amount!=0)
            return -1;
        
        return cnt;
    }
}