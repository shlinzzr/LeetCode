// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        
        
        for(int i=0; i<candies.length; i++){
            
            int max = candies[i] + extraCandies;
            boolean bool = true;
            for(int j=0; j<candies.length; j++){
                
                if(i==j)
                    continue;
                
                if(candies[j] > max)
                    bool = false;
                
            }
            list.add(bool);
            
            
        }        
        return list;
    }
}