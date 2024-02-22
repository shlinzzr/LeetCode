// https://leetcode.com/problems/last-visited-integers

class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int idx=0;
        for(int i=0; i<words.size(); i++){
            
            String s = words.get(i);
            if(s.equals("prev")){
                
                while(idx>=0 && words.get(idx).equals("prev"))
                    idx--;
                
                if(idx==-1)
                    res.add(-1);
                else 
                    res.add(Integer.valueOf(words.get(idx--)));
            }
               
            else{
                idx=i;
                list.add(Integer.valueOf(s));
                
            }
                
            
        }
                            
                            return res;
    } 
}