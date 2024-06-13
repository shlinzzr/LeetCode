// https://leetcode.com/problems/occurrences-after-bigram

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        
        List<String> list = new ArrayList<>();
        
        String[] arr = text.split(" ");
        for(int i=0; i<arr.length-2; i++){
            
            if(arr[i].equals(first) && arr[i+1].equals(second)){
                list.add(arr[i+2]);
            }
        }
        
        String[] res = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}