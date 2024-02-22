// https://leetcode.com/problems/count-items-matching-a-rule

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        
        int idx = 0;
        if(ruleKey.charAt(0)=='c')
            idx=1;
        else if(ruleKey.charAt(0)=='n')
            idx=2;
        
        
        int cnt=0;
        for(int i=0; i<items.size(); i++){
            
            if(items.get(i).get(idx).equals(ruleValue))
                cnt++;
            
            
//             String type = items.get(i).get(0);
//             String color = items.get(i).get(1);
//             String name = items.get(i).get(2);
            
//             switch(ruleKey){
//                 case "type":
//                     if(type.equals(ruleValue))
//                         cnt++;
//                     break;
//                 case "color":
//                     if(color.equals(ruleValue))
//                         cnt++;
//                     break;
//                 case "name":
//                     if(name.equals(ruleValue))
//                         cnt++;
//                     break;
//             }
            
        }
        
        return cnt;
        
    }
}