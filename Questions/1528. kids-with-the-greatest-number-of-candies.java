// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int max = 0;
        
        for(int c : candies){
            max = Math.max(max, c);
        }
        
        List<Boolean> res = new ArrayList<>();
        
        for(int i=0; i<candies.length; i++){
            
            if(candies[i]+extraCandies >= max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        
        return res;
        
        
        
    }
}