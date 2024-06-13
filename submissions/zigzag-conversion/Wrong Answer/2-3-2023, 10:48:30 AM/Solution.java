// https://leetcode.com/problems/zigzag-conversion

class Solution {
    public String convert(String s, int numRows) {
        
         if(numRows==1)
             return s;
        
        
        int len = s.length();
        
        List<List<Character>> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            list.add(new ArrayList<>());
        }
        
        int i=0;
        while(i<len){
            
            int idx = i%(( numRows + numRows-2));
            if(idx>=numRows){
                idx = (numRows-3) - (idx%(numRows-2))+1;
            }
            
            System.out.println(i + " " + idx);
            
            list.get(idx).add(s.charAt(i));
            i++;
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(int ii=0; ii<len; ii++){
            
            for(int j=0; j<list.get(ii).size(); j++){
                sb.append(list.get(ii).get(j));
                
            }
            
            System.out.println(sb.toString());
        }
        
        return sb.toString();
        
        
    }
}