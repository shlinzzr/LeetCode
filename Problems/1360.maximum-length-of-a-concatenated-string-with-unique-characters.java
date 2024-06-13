// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters

class Solution {
    public int maxLength(List<String> arr) {
        List<String> res = new ArrayList<>();

        helper(arr, 0, "", res);
        int max =0;
        for(String r : res){
            max = Math.max(max, r.length());
        }
        return max;
    }

    private void helper(List<String> arr, int idx, String curr, List<String> res){
        if(idx==arr.size()){
            return;
        }

        for(int i=idx; i<arr.size(); i++){

           
            int[] check = new int[26];
            for(char ch : curr.toCharArray())
                check[ch-'a']++;
            
            for(char ch : arr.get(i).toCharArray())
                check[ch-'a']++;
            

            boolean dul= false;
            for(int c : check){
                if(c>1) dul=true;
            }

            if(dul) continue;

            res.add(curr+arr.get(i));
            helper(arr, i+1, curr+arr.get(i), res);
        }
    }
}