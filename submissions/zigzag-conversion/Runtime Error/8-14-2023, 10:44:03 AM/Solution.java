// https://leetcode.com/problems/zigzag-conversion

class Solution {
    public String convert(String s, int numRows) {
        List<Character> first = new ArrayList<>();
        List<Character> second = new ArrayList<>();
        List<Character> third = new ArrayList<>();
        
        List<Character>[] arr = new List[numRows];
        
        boolean goDown = false;
        
        int idx =0;
        
        for(char ch : s.toCharArray()){
            
            if(arr[idx]==null)
                arr[idx] = new ArrayList<>();
            
            arr[idx].add(ch);
            
            
            if(idx==0 || idx==numRows-1){
                goDown = !goDown;
            }
            
            if(goDown)
                idx++;
            else 
                idx--;
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for(List<Character> list : arr){
            
            if(list!=null)
            for(char ch : list){
                sb.append(ch);
            }
        }
        
        return sb.toString();
        
        
    }
}