// https://leetcode.com/problems/shopping-offers

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // special[i] : 第i offer
        // special[i][j=0~n-1] 第i個offer中item j 的數量
        // special[i][n] : price of #i offer

        int nonSpecialPrice =0;

        for(int k=0; k<special.size(); k++){
            int specialCnt = Integer.MAX_VALUE;
            for(int i=0; i<needs.size(); i++){
                if(special.get(k).get(i)==0) continue;
                specialCnt = Math.min(specialCnt, needs.get(i)/special.get(k).get(i));
                
                if(k==0)
                    nonSpecialPrice += price.get(i)*needs.get(i);
            }

            int maxSpecialPrice = 0;
            for(int i=0; i<needs.size(); i++){
                maxSpecialPrice += (needs.get(i)-specialCnt*special.get(k).get(i))*price.get(i);
            }

            nonSpecialPrice = Math.min(maxSpecialPrice, nonSpecialPrice);
        }


        

       return nonSpecialPrice;


        
    }

}