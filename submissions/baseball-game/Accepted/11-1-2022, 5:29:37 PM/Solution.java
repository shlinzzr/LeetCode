// https://leetcode.com/problems/baseball-game

class Solution {
    public int calPoints(String[] operations) {
        
        int res = 0;
        List<Integer> list = new ArrayList<>();
        int currSum=0;
        for(String s : operations){
            if(s.equals("+")){
                int prev = list.get(list.size()-1);
                int prevprev = list.get(list.size()-2);
                currSum+=prev+prevprev;
                list.add(prev+prevprev);
                
            }else if(s.equals("C")){
                currSum-=list.get(list.size()-1);
                list.remove(list.size()-1);
            
            }else if(s.equals("D")){
                currSum+=(list.get(list.size()-1)*2);
                list.add(list.get(list.size()-1)*2);
                
            }else{
                currSum+=Integer.valueOf(s);
                list.add(Integer.valueOf(s));
            }
            
        }
        
        return currSum;
        
    }
}