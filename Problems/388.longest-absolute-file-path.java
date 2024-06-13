// https://leetcode.com/problems/longest-absolute-file-path

class Solution {
    
    class TrieNode{
        
        TrieNode[] arr;
        boolean isFile;
        String path;
        
        public TrieNode(){
            arr = new TrieNode[26];
        }
        
    }
    
    TrieNode root = new TrieNode();
    
    
    public int lengthLongestPath(String input) {
        
        String[] arr = input.split("\n");
        
        
        String res = "";
        
        List<String> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            String row = arr[i];
            
            String[] sub = row.split("\t", -1);
            StringBuilder sb = new StringBuilder();
            
            boolean isLastStringFile = false;
            for(int j=0; j<sub.length; j++){
                String s = sub[j];
                if(!sb.isEmpty()) sb.append("/");
                
                String candidate  = "";
                if(!s.isEmpty()){
                    if(list.size()<j+1){
                        list.add(s);
                    }else{
                        list.set(j, s);
                    }
                    candidate = s;
                    
                }else{
                    candidate = list.get(j);
                }
                
                
                if(j==sub.length-1){
                    if(candidate.contains("."))
                        isLastStringFile=true;
                }
                sb.append(candidate);
                
                
            }
            if(isLastStringFile && sb.length()>res.length()){
                res = sb.toString();
            }
            
        }
        
        // System.out.println(res);
        return res.length();
        
        
        
    }
}