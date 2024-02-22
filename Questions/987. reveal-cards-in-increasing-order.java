// https://leetcode.com/problems/reveal-cards-in-increasing-order

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        
        int[] res = new int[deck.length];
        
        int len = deck.length;
        
        boolean dummy = false;
        
        int i=0, cnt=0;
        while(cnt<len){
            
            if(res[i%len]==0){
                if(dummy==false){
                    res[i%len] = deck[cnt++];
                    dummy =true;
                }else{
                    dummy =false;
                }
            }
            i++;
        }
        
        return res;
        
        
        
    }
}