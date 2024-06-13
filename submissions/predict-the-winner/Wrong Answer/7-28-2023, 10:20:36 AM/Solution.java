// https://leetcode.com/problems/predict-the-winner

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int score1 =0, score2=0;
        
        List<Integer> list = new ArrayList<>();
        for(int n: nums){
            list.add(n);
        }
        
        
        boolean p1 = true;
        while(!list.isEmpty()){
            
            
            if(list.get(0)>=list.get(list.size()-1)){
                
                if(p1){
                    score1 += list.get(0);
                }else{
                    score2 += list.get(0);
                }
                list.remove(0);
            }else{

                if(p1)
                    score1 += list.get(list.size()-1);
                else 
                    score2 += list.get(list.size()-1);
                
                list.remove(list.size()-1);
            }
                
            p1 = !p1;
        }
        // System.out.println(score1 + " " + score2 );
        return score1>=score2;
    }
}