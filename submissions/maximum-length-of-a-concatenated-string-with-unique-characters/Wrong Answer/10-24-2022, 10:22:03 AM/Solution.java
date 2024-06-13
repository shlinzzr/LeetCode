// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters

class Solution {
    public int maxLength(List<String> arr) {
        List<String> res = new ArrayList<>();
        
        dfs(arr, res, "", 0);
        
        int max = 0;
        for(String s :res ){
            // System.out.println(s);
            max = Math.max(max, s.length());
        }
        
        return max;
    }
    
    private void dfs(List<String> arr, List<String> res, String curr, int st){
        
        if(st>arr.size())
            return;
        
        res.add(curr);
        for(int i=st; i<arr.size(); i++){
            
            boolean exist = false;
            for(char c : arr.get(i).toCharArray()){
                if(curr.contains(String.valueOf(c)) )
                    exist=true;
            }
            if(!exist)
                dfs(arr, res, curr+arr.get(i), i+1);
        }
        
    }
}