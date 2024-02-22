// https://leetcode.com/problems/account-balance-after-rounded-purchase

class Solution {
    public int accountBalanceAfterPurchase(int pa) {
        
        
        if(pa%10>=5){
            pa=(pa/10+1)*10;
        }else{
            pa= pa/10*10;
        }
        
        return 100-pa;
        
    }
}