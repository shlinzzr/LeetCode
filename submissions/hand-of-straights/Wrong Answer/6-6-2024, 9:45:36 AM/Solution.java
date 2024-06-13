// https://leetcode.com/problems/hand-of-straights

class Solution {
    public boolean isNStraightHand(int[] hand, int g) {
        
        int len = hand.length;
        if(len%g!=0) return false;
        
        Arrays.sort(hand);
        
        
        int[] arr = new int[g];
        Arrays.fill(arr, -1);
        for(int i=0; i<len; i++){
             int n = hand[i];
            
            boolean match = false;
            for(int j=0; j<g; j++){
                if(n > arr[j]){
                    arr[j]=n;
                    match=true;
                    break;
                }
            }
            
            if(match==false) return false;
           
            
            
        }
        
        return true;
    }
}